package unit10.assignment2.auction;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import unit10.Duplexer;

public class AuctionServer implements AuctionProtocol {

    private class ClientHandler implements Runnable {
        private Duplexer duplexer;
        private String clientName;

        public ClientHandler(Socket socket) throws IOException {
            this.duplexer = new Duplexer(socket);
            synchronized (clientHandlers) {
                clientHandlers.add(this);
            }
        }

        @Override
        public void run() {
            this.clientName = duplexer.read();
            String msg = CURRENT + ":" + highestBidder + " " + highestBid;
            duplexer.send(msg);

            while (!auctionEnd) {
                msg = duplexer.read();
                System.out.println(clientName + " " + msg);
                String[] tokens = msg.split(":");
                if (tokens[0].equals(BID)) {
                    int bid = Integer.parseInt(tokens[1]);
                    synchronized (clientHandlers) {
                        if (bid <= highestBid) {
                            duplexer.send(ERROR + ":too low");
                        } else {
                            if (!auctionEnd) {
                                highestBid = bid;
                                highestBidder = clientName;

                                for (ClientHandler ch : clientHandlers) {
                                    ch.duplexer.send(CURRENT + ":" + highestBidder + " " + highestBid);
                                }
                            }
                        }
                    }
                } else {
                    duplexer.send("ERROR:invalid command " + tokens[0]);
                }
            }
            duplexer.send(END + ":" + highestBidder + " " + highestBid);
            try {
                duplexer.close();
            } catch (IOException ioe) {
            }
            System.out.println("Client handler has been closed.");
        }
    }

    private boolean auctionEnd;
    private int highestBid;
    private String highestBidder;
    private ServerSocket serverSocket;
    private List<ClientHandler> clientHandlers;

    public AuctionServer(int port, int biddingPeriod) throws IOException {

        this.highestBid = 0;
        this.highestBidder = "No one";
        this.auctionEnd = false;
        this.clientHandlers = new ArrayList<>();

        startTimer(biddingPeriod);
        startListener(port);
    }

    private void startListener(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (!auctionEnd) {
            try {
                Socket socket = serverSocket.accept(); // SocketException
                new Thread(new ClientHandler(socket)).start();

            } catch (SocketException ioe) {
                auctionEnd = true;
            }
        }
        System.out.println("Auction has been closed");
    }

    private void startTimer(int biddingPeriod) {
        Thread timer = new Thread(() -> {
            try {
                Thread.sleep(biddingPeriod * 1000);
                this.auctionEnd = true;
                serverSocket.close();
            } catch (Exception ie) {
            }
        });
        timer.start();
    }

    public static void main(String[] args) throws IOException {
        int port = 54322;
        int biddingPeriod = 40; // in seconds
        new AuctionServer(port, biddingPeriod);
    }
}

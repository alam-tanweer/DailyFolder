package unit12.assignment2.auction;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import unit12.Duplexer;

public class AuctionClient implements AuctionProtocol {
    private Duplexer duplexer;
    private Scanner userIn;
    private boolean auctionEnd;

    private class Listener implements Runnable {
        @Override
        public void run() {
            while (!auctionEnd) {
                String msg = duplexer.read();
                String[] tokens = msg.split(":");
                if (tokens[0].equals(END)) {
                    System.out.println("Auction has ended.");
                    System.out.println("The winner is " + tokens[1]);
                    auctionEnd = true;
                    break;
                } else if (tokens[0].equals(CURRENT)) {
                    System.out.println("Current highest is " + tokens[1]);
                } else if (tokens[0].equals(ERROR)) {
                    System.out.println("Your bidding is " + tokens[1]);
                } else {
                    System.out.println("Invalid command received!");
                }
            }
        }
    }

    public AuctionClient(Socket socket) throws IOException {
        this.duplexer = new Duplexer(socket);
        this.userIn = new Scanner(System.in);
        auctionEnd = false;
        task();
    }

    public void task() throws IOException {
        Thread listener = new Thread(new Listener());
        listener.start();

        System.out.println("Enter your name: ");
        String name = userIn.nextLine();
        duplexer.send(name);

        while (!auctionEnd) {
            System.out.println("Enter your bid:");
            try {
                int bid = Integer.parseInt(userIn.nextLine());
                duplexer.send(BID + ":" + bid);
            } catch (NumberFormatException ime) {
            }
        }
        duplexer.close();
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 54322);
        new AuctionClient(socket);
    }
}

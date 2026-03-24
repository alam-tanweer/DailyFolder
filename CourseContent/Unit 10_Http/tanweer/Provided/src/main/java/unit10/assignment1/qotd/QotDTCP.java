package unit10.assignment1.qotd;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import unit10.Duplexer;

public class QotDTCP implements Runnable, QotDProtocol {

    private final QotD qotd;
    private final int port;

    public QotDTCP(QotD qotd, int port) throws IOException {
        this.qotd = qotd;
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket client = server.accept()) {
                    Duplexer duplexer = new Duplexer(client);
                    String request = duplexer.read();
                    String response;
                    switch (request) {
                        case INSPIRATIONAL:
                            response = qotd.getRandomInspirationalQuote();
                            break;
                        case HISTORY:
                            response = qotd.getRandomHistoricalQuote();
                            break;
                        case DEEP:
                            response = qotd.getRandomDeepQuote();
                            break;
                        default:
                            response = "ERROR";
                            break;
                    }
                    duplexer.send(response);
                } catch (IOException ioe) {
                    System.err.println("Error communicating with client: ");
                    ioe.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // server crash
        }
    }
    
}

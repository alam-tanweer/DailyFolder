import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import duplexer.Duplexer;

public class TinyChatServer  {
    private static final int PORT = 54321;

    public static void main(String[] args) {
        List<Duplexer> clients = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Listening on port " + PORT);
            while (true) {
                Socket client = serverSocket.accept();
                new Thread(new ClientHandler(client,clients)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
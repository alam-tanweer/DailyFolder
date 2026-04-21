package mte.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            List<String> messages = new ArrayList<>();

            try (
                Socket socket = clientSocket;
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String line;

                while ((line = in.readLine()) != null) {
                    if ("EXIT".equalsIgnoreCase(line.trim())) {
                        break;
                    }
                    messages.add(line);
                }

                String response = String.join(",", messages);
                int count = messages.size();

                out.println("MESSAGE: " + response);

                out.println("TOTAL MESSAGE RECEIVED: " + count);
                out.flush();

                System.out.println("Processed client " + socket.getRemoteSocketAddress()
                        + " -> Response: " + response + " | Count: " + count);

            } catch (IOException e) {
                System.err.println("Client handling error: " + e.getMessage());
            }
        }
    } 
}
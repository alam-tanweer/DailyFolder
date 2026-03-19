package unit09.activities;

import java.net.*;
import java.io.*;
import java.util.*;

public class EchoServer {

    public static void runServerStandalone() throws IOException {
        // Activity 11.2.4
        ServerSocket server = new ServerSocket(54321);

        Socket client = server.accept();

        Scanner in = new Scanner(client.getInputStream());
        String message = in.nextLine();
        System.out.println(message);

        // Activity 11.2.5
        PrintWriter out = new PrintWriter(client.getOutputStream());
        out.println(message);
        out.flush();
        in.close();

        server.close();
        client.close();
    }

    public static void runMultiResponseServer() throws IOException {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");

            while (true) {

                Socket client = server.accept();

                try {

                    System.out.println("Accepted client from " + client.getInetAddress());
                    BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream());

                    while (true) {
                        String data = reader.readLine();
                        if (data == null || data.equals("exit")) {
                            break;
                        } else {
                            out.println(data.toUpperCase());
                            out.flush();
                            System.out.println("Message Send: " + data.toUpperCase());
                        }
                    }

                    client.close();
                } catch (Exception ex) {
                    System.out.println("Connection closed.");
                }

                System.out.println("Client Terminated.");

            }
        }
    }

    public static void runThreadedServer() throws IOException {
        try (ServerSocket server = new ServerSocket(12345)) {
            System.out.println("Server started on port 12345");
            while (true) {

                Socket client = server.accept();

                new EchoServer().new SocketThread(client).start();
            }
        }
    }

    public static void main(String[] args) throws IOException {

        // runServerStandalone();
        runMultiResponseServer();
        // runThreadedServer();


        //Reference only
        // try (ServerSocket server = new ServerSocket(12345)) {
        //     System.out.println("Server started on port 12345");
        //     while (true) {

        //         Socket client = server.accept();

        //         new EchoServer().new SocketThread(client).start();

                // try {

                // System.out.println("Accepted client from " + client.getInetAddress());
                // BufferedReader reader = new BufferedReader(new
                // InputStreamReader(client.getInputStream()));
                // PrintWriter out = new PrintWriter(client.getOutputStream());

                // while (true) {
                // String data = reader.readLine();
                // if (data == null || data.equals("exit")) {
                // break;
                // } else {
                // out.println(data.toUpperCase());
                // out.flush();
                // System.out.println("Message Send: " + data.toUpperCase());
                // }
                // }
                // } catch (Exception ex) {
                // System.out.println("Connection closed.");
                // }

                // System.out.println("Client Terminated.");

            // }
        // }
    }

    class SocketThread extends Thread {
        Socket client;

        public SocketThread(Socket socket) {
            this.client = socket;
        }

        public void run() {
            try {

                System.out.println("Accepted client from " + client.getInetAddress());
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream());

                while (true) {
                    String data = reader.readLine();
                    if (data == null || data.equals("exit")) {
                        break;
                    } else {
                        out.println(data.toUpperCase());
                        out.flush();
                        System.out.println("Message Send: " + data.toUpperCase());
                    }
                }
            } catch (Exception ex) {
                System.out.println("Connection closed.");
            }

            System.out.println("Client Terminated.");
        }
    }
}

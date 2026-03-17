package unit12.assignment2.tinychat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import unit12.Duplexer;

public class TinyChatServer {
    Map <String, Duplexer> clients;

    private class ClientHandler implements Runnable {
        private Duplexer client;
        private String name;

        public ClientHandler (Socket sock) throws IOException {
            client = new Duplexer (sock);
        }

        @Override
        public void run() {
            name = client.read ();
            clients.put (name, client);
            client.send ("Connected");

            String message = "Connected";
            while (true){
                for (String key : clients.keySet()) {
                    Duplexer client = clients.get (key);
                    if (client != this.client) {
                        client.send (name + ": " + message);
                    }
                }
                if (message.equals("Quit")) {
                    break;
                }
                message = client.read ();
            }
            try {
                client.send ("Closing");
                client.close ();
            } catch (Exception e) {}
        }
    }

    public TinyChatServer () {
        clients = new HashMap<> ();
        ServerSocket server = null;
        try {
            server = new ServerSocket (12345);
            while (true) {
                Socket client = server.accept ();
                new Thread (new ClientHandler (client)).start ();
            }
        } catch (IOException ioe) {
            if (server != null) {
                try {
                    server.close ();
                } catch (IOException e) {}
            }
        } 
    }

    public static void main(String[] args) {
        new TinyChatServer ();
    }
}
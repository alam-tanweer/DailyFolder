package unit13;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {

    public static void sendMessage (Socket sock, String message) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(sock.getOutputStream());
            out.println (message);
            System.out.println("Sent the message.");
        }
        catch(IOException ioe) {
                System.out.println("Cannot send message!");
                throw ioe;
        }
        finally {
            System.out.println("Closed the stream.");
            out.close();
        }
    }

    public static void main (String[] args) {
        try {
            Socket sock = 
                new Socket(args[0], Integer.parseInt(args[1]));
            sendMessage(sock, "Hello");
        }
        catch(Exception e) {
            System.out.println("Client failed.");
        }
    }
}
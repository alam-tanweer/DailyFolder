package unit09.activities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Listener {
    public static void main(String[] args) throws IOException {

        // Each call server shuts down
        // ServerSocket server = new ServerSocket (12345);
        // Socket client = server.accept ();
        // System.out.println ("Connected!");
        // server.close ();
        // client.close ();


        try(ServerSocket server = new ServerSocket (12345)) {
            while (true) {
                Socket client = server.accept ();
                System.out.println ("Accepted client from " + client.getInetAddress());
                Scanner in = new Scanner (client.getInputStream());
                if (in.hasNextLine()) {
                    System.out.println (in.nextLine());
                }
                in.close();
            }
        }
    }
}

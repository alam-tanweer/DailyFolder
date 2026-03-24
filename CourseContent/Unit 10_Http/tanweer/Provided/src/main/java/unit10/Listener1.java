package unit10;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Listener1 {
    public static void main(String[] args) throws IOException {
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

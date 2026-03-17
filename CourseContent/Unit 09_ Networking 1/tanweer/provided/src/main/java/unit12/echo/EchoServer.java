package unit12.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        // Activity 11.2.4
        ServerSocket server = new ServerSocket (54321);
        Socket client = server.accept();

        Scanner in = new Scanner (client.getInputStream ());
        String message = in.nextLine();
        System.out.println (message);

        // Activity 11.2.5
        PrintWriter out = new PrintWriter (client.getOutputStream ());
        out.println (message);
        out.flush ();
        in.close();

        server.close ();
        client.close ();
    }  
}

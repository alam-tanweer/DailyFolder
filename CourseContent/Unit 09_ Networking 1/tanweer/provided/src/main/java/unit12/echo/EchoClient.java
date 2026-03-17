package unit12.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        // Activity 11.2.3
        Socket client = new Socket ("localhost", 54321);
        PrintWriter printer = new PrintWriter (client.getOutputStream ());

        String message = "Is anybody out there?";
        System.out.println ("Sending: " + message);
        printer.println (message); 
        printer.flush ();

        // Activity 11.2.5
        Scanner in = new Scanner (client.getInputStream ());
        System.out.println ("Recived: " + in.nextLine ());

        in.close();
        client.close ();
    }
}

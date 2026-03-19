package unit09.activities;

import java.net.*;
import java.io.*;
import java.util.*;

public class EchoClient {

    public static void runClientStandAlone()  throws IOException  {
        // // Activity 11.2.3
        Socket client = new Socket ("localhost", 12345);
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

    public static void runInteractiveClient() throws IOException {
        // Activity 11.2.3
        Socket client = new Socket("localhost", 12345);
        Scanner scan = new Scanner(System.in);

        Scanner in = new Scanner(client.getInputStream());
        PrintWriter printer = new PrintWriter(client.getOutputStream());

        System.out.println("Enter exit to quit.");

        while (true) {
            System.out.println("Enter a message : ");
            String message = scan.nextLine();

            if (message.equals("exit")) {
                break;
            }

            // Send message
            System.out.println("Sending: " + message);
            printer.println(message);
            printer.flush();

            // Read response
            System.out.println("Message received: " + in.nextLine());
        }

        in.close();
        client.close();
        scan.close();        
    }

    public static void main(String[] args) throws IOException {

        // runClientStandAlone();

        runInteractiveClient();


        // Below code For reference only.

        // // Activity 11.2.3
        // Socket client = new Socket("localhost", 12345);
        // Scanner scan = new Scanner(System.in);

        // Scanner in = new Scanner(client.getInputStream());
        // PrintWriter printer = new PrintWriter(client.getOutputStream());

        // System.out.println("Enter exit to quit.");

        // while (true) {
        //     System.out.println("Enter a message : ");
        //     String message = scan.nextLine();

        //     if (message.equals("exit")) {
        //         break;
        //     }

        //     // Send message
        //     System.out.println("Sending: " + message);
        //     printer.println(message);
        //     printer.flush();

        //     // Read response
        //     System.out.println("Message received: " + in.nextLine());
        // }

        // in.close();
        // client.close();
        // scan.close();
    }
}

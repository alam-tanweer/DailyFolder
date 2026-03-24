package unit10.calculator;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalculatorClient {
    
    public CalculatorClient () throws IOException {
        Scanner in = new Scanner (System.in);
        System.out.print ("Enter math operation: ");
        String input = in.nextLine ();

        DatagramSocket dsock = new DatagramSocket ();

        while (!input.equals(" ")) {
            byte[] outgoing = input.getBytes();
            DatagramPacket packet = new DatagramPacket (outgoing, outgoing.length,
                InetAddress.getByName ("nitron.se.rit.edu"), 12400);
            dsock.send (packet);

            byte[] data = new byte [1024];
            DatagramPacket operation = new DatagramPacket (data, data.length);
            dsock.receive(operation);
            String response = new String (data, 0, operation.getLength ());
            System.out.print (response + " ");
            try {
                if (Double.isNaN (Double.parseDouble(response))) {
                    throw new NumberFormatException ();
                }
            } catch (NumberFormatException nfe) { 
                response = "";
                System.out.println ();
            }
            input = in.nextLine();
            input = response + " " + input;
        }

        in.close ();
        dsock.close ();
    }

    public static void main(String[] args) throws IOException {
        new CalculatorClient ();
    }
}

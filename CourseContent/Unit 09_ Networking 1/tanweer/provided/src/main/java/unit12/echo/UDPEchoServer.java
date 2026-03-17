package unit12.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) throws IOException {

        // Activity 11.2.6
        DatagramSocket server = new DatagramSocket (54321);
        byte[] buffer = new byte[1024];
        DatagramPacket incomming = new DatagramPacket (buffer, buffer.length);
        
        server.receive (incomming);
        String message = new String(incomming.getData(), 0, incomming.getLength());
        System.out.println (message);

        // Activity 11.2.7
        DatagramPacket outgoing = new DatagramPacket (message.getBytes(), message.length(),
                                                      incomming.getAddress (), incomming.getPort ());
        server.send (outgoing);

        server.close ();
    } 
}

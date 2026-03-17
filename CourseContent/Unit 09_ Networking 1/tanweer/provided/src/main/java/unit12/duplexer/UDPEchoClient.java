package unit12.duplexer;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPEchoClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("localhost");
        int port = 54321;

        Duplexer duplexer = new UDPlexer(socket, address, port, true);

        duplexer.send("Hello, World!");

        String response = duplexer.receive();
        System.out.println(response);

        duplexer.close();
    }
    
}

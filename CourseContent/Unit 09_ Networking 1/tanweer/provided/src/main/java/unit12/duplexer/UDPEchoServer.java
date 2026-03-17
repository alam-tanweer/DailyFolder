package unit12.duplexer;

import java.net.DatagramSocket;

public class UDPEchoServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(54321);
        
        Duplexer duplexer = new UDPlexer(socket, true);

        String message = duplexer.receive();
        System.out.println(message);

        duplexer.send("ECHO: " + message);

        duplexer.close();
    }
}

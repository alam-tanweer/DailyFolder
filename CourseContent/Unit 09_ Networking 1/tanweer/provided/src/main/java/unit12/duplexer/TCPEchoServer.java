package unit12.duplexer;

import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(54321);
        Socket client = server.accept();

        Duplexer duplexer = new TCPlexer(client);

        String message = duplexer.receive();
        System.out.println(message);

        duplexer.send("ECHO: " + message);

        duplexer.close();
        server.close();
    }
    
}

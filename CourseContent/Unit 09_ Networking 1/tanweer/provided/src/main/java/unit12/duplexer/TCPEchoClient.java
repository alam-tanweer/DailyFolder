package unit12.duplexer;

import java.net.Socket;

public class TCPEchoClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 54321);

        Duplexer duplexer = new TCPlexer(socket);
        duplexer.send("Hello, World!");
        
        String response = duplexer.receive();
        System.out.println(response);

        duplexer.close();
    }
}

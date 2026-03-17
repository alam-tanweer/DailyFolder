package unit12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener2 {
  
    public static void main (String[] args) throws IOException{    
        ServerSocket server = new ServerSocket (12347);
        Socket client = server.accept ();
        System.out.println ("Connected!");
        server.close ();
        client.close ();
    }
}


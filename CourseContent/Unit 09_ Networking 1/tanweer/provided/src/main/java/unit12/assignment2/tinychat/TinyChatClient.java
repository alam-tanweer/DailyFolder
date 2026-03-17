package unit12.assignment2.tinychat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import unit12.Duplexer;

public class TinyChatClient {
    private Duplexer server;

    public TinyChatClient () throws IOException {
        Socket serverSock = new Socket ("localhost", 12345);
        this.server = new Duplexer (serverSock);
    }

    public void run () {
        Scanner in = new Scanner (System.in);
        System.out.print ("Enter your name to connect to tinychat: ");
        String message = in.nextLine ();
        server.send (message);
        System.out.println (server.read());

        //Start the listener
        new Thread (()->{
            String response;
            while (true) {
                response = server.read ();
                if (response.equals("Closing")) {break;}
                System.out.println (response);
            }
        }).start ();

        do {
            message = in.nextLine ();
            server.send(message);
        } while (!message.equals ("Quit"));

        in.close ();
    }

    public static void main(String[] args) throws IOException {
        TinyChatClient tcc = new TinyChatClient ();
        tcc.run ();
    }
}

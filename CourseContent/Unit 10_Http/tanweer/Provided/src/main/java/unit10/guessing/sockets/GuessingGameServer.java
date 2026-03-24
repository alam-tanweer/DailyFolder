package unit10.guessing.sockets;
import java.net.*;

import unit10.Duplexer;
import unit10.guessing.GuessResult;
import unit10.guessing.GuessingGameImpl;


import java.io.*;

/**
 * GuessingGameServer
 */
public class GuessingGameServer extends Duplexer implements Runnable {

    GuessingGameImpl game;

    public GuessingGameServer (Socket sock) throws IOException {
        super (sock);
        game = new GuessingGameImpl ();
    }

    @Override
    public void run () {
        String request = "";
        while (!request.equals("QUIT")) {
            request = read ();
            System.out.println ("RECV: " + request);

            String[] tokens = request.split (" ");

            String response = "";
            switch (tokens[0]) {
                case "QUIT":
                    game.quit ();
                    response = "GAME_OVER";
                break;
                case "RESTART":
                    game.restart ();
                    response = "RESTARTED";
                break;
                case "GUESS":
                    GuessResult res = game.guess (Integer.parseInt (tokens[1]));
                    response = res.toString ();
                break;
                default:
                    response = "ERROR: Unknown Command - " + request;
           }
           System.out.println ("SEND: " + response);
           send (response);
        }
        try {
            close ();
        } catch (IOException ioe) {}
    }

    public static void main (String[] args) throws IOException {
        ServerSocket server = new ServerSocket (12345);
        try { // Added try so there is a close for server
            while (true) {
                System.out.println ("Waiting for client ... ");
                Socket client = server.accept ();
                GuessingGameServer gameServer = new GuessingGameServer (client);

                System.out.println ("Starting the game ...");
                new Thread (gameServer).start ();
            }
        } catch (IOException ioe) {
            server.close ();
        } 
    }
    
}
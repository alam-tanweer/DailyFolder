package unit12.guessing;

import java.io.IOException;
import java.net.Socket;

import unit12.Duplexer;

public class GuessingGameProxy extends Duplexer implements GuessingGame {

    public GuessingGameProxy (Socket sock) throws IOException {
        super(sock);
    }

    @Override
    public void restart () {
        send ("RESTART");
        String response = read ();
        if (!response.equals ("RESTARTED")) {
            System.out.println ("Server did not restart!");
        }
    }

    @Override
    public GuessResult guess (int number) {
        send ("GUESS " + number);
        String response = read ();
        return GuessResult.valueOf (response);
    }

    @Override
    public void quit () {
        send ("QUIT");
        read ();
        try {
            close ();
        } catch (IOException ioe) { /* Squash */};
    }

}
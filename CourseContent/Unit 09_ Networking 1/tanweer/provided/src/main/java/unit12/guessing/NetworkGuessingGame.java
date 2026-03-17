package unit12.guessing;

import java.io.IOException;
import java.net.Socket;

public class NetworkGuessingGame {

    public static void main (String[] args) throws IOException{
        Socket server = new Socket ("localhost", 12345);
        GuessingGame game = new GuessingGameProxy (server);
        GamePlayer player = new GamePlayer (game);
        player.playTheGame ();
    }
}
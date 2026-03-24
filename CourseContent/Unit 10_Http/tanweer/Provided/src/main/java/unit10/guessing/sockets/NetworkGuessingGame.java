package unit10.guessing.sockets;

import java.io.IOException;
import java.net.Socket;

import unit10.guessing.GamePlayer;
import unit10.guessing.GuessingGame;

public class NetworkGuessingGame {

    public static void main (String[] args) throws IOException{
        Socket server = new Socket ("localhost", 12345);
        GuessingGame game = new GuessingGameProxy (server);
        GamePlayer player = new GamePlayer (game);
        player.playTheGame ();
    }
}
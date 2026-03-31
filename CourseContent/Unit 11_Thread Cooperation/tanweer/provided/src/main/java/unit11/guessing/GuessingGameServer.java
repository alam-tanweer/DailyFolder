package unit11.guessing;

import unit11.guessing.model.GuessingGameHandler;
import unit11.httpserver.HttpWebServerMT;


/**
 * GuessingGameServer
 */
public class GuessingGameServer  {

    public static void main (String[] args)  {
        HttpWebServerMT server = new HttpWebServerMT(8081, GuessingGameHandler::new);
        server.start();
    }
    
}
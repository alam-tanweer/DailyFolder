package unit11.guessing;

import unit11.guessing.model.GuessingGameHandler;
import unit11.httpserver.HttpWebServer;


/**
 * GuessingGameServer
 */
public class GuessingGameServer  {

    public static void main (String[] args)  {
        HttpWebServer server = new HttpWebServer(8081, GuessingGameHandler::new);
        server.start();
    }
    
}
package unit10.guessing;

import unit10.httpserver.RequestHandler;
import unit10.httpserver.SecondHttpWebServer;


/**
 * GuessingGameServer
 * 
 * Activity 10.2
 */
public class GuessingGameServerSingle  {

    public static void main (String[] args)  {
        RequestHandler handler = new GuessingGameHandler();    
        SecondHttpWebServer server = new SecondHttpWebServer(8081, handler);
        server.start();
    }
    
}
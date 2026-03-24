package unit10.guessing;

import unit10.httpserver.FourthHttpWebServer;
import unit10.httpserver.ThirdHttpWebServer;


/**
 * GuessingGameServer
 */
public class GuessingGameServerMulti  {

    /** Change version between thrid and fourth to run the variants **/
    private static final String SERVER_VERSION = "fourth";

    public static void main (String[] args)  {

        if (SERVER_VERSION.equals("third")) {
            /** Used in Activity 10.16 and 10.17 **/
            ThirdHttpWebServer server = new ThirdHttpWebServer (8081);
            server.start();
        }

        if (SERVER_VERSION.equals("fourth")) {
            /** Used in Activity 10.18 **/
            FourthHttpWebServer server = new FourthHttpWebServer(8081, GuessingGameHandler::new);
            server.start();
        }
    }
    
}
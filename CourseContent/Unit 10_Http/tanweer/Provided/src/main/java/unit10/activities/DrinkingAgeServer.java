package unit10.activities;

import unit10.httpserver.SecondHttpWebServer;
import unit10.httpserver.RequestHandler;

public class DrinkingAgeServer {
    public static void main(String[] args) {
        RequestHandler handler = new DrinkingAgeHandler();    
        SecondHttpWebServer server = new SecondHttpWebServer(8081, handler);
        server.start();
    }
}

package unit11.guessing.model;

import unit11.httpserver.HttpRequest;
import unit11.httpserver.RequestHandler;

/**
 * Activity 10.12 and 10.13
 */

public class GuessingGameHandler implements RequestHandler {
    private final GuessingGameImpl game;

    public GuessingGameHandler () {
        game = new GuessingGameImpl();
    }

    @Override
    public String handleRequest(HttpRequest request) {
        String requestStr = request.getBody(); 
        String[] tokens = requestStr.split (" ");

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
        return response;
    }
}

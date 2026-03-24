package unit10.guessing;

import unit10.httpserver.HttpRequest;
import unit10.httpserver.RequestHandler;

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
        if (request.getMethod() != HttpRequest.Method.POST) {
            return null;
        }

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

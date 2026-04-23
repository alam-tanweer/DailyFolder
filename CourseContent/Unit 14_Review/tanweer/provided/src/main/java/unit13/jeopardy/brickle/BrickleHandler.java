package unit13.jeopardy.brickle;

import unit13.httpserver.HttpRequest;
import unit13.httpserver.RequestHandler;

public class BrickleHandler implements RequestHandler{
    private Brickle game;

    public BrickleHandler() {
        this.game = new Brickle("TIGER");
    }

    private boolean isRoute(HttpRequest request,HttpRequest.Method method,String uri) {
        return request.getMethod() == method && request.getUri().equals(uri);
    }

    @Override
    public String handleRequest(HttpRequest request) {
        if (isRoute(request,HttpRequest.Method.GET,"/gamestate"))
            return game.getGameState().toString();
        else if (isRoute(request,HttpRequest.Method.GET,"/guessesleft"))
            return Integer.toString(game.getGuessesLeft());
        else if (isRoute(request,HttpRequest.Method.POST,"/guess")) {
            String guess = request.getBody();
            try {
                return game.guess(guess);
            } catch (IllegalStateException | IllegalArgumentException e) {
                return "ERROR: " + e.getMessage();
            }
        }

        return null;
    }
}

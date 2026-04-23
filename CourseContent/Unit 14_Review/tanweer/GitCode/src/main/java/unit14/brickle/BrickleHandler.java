package unit14.brickle;

import unit14.httpserver.HttpRequest;
import unit14.httpserver.RequestHandler;

public class BrickleHandler implements RequestHandler{
    private Brickle game;

    public BrickleHandler() {
        this.game = new Brickle("TIGER");
    }

    @Override
    public String handleRequest(HttpRequest request) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}

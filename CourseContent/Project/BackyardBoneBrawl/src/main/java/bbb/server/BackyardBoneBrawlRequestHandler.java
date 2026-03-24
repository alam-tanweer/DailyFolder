package bbb.server;

import bbb.httpserver.HttpRequest;
import bbb.httpserver.HttpRequest.Method;
import bbb.httpserver.RequestHandler;
import bbb.model.BackyardBoneBrawlGame;
import bbb.model.BackyardBoneBrawlGameImpl;
import bbb.model.TurnResult;
import bbb.model.YardCoordinate;

public class BackyardBoneBrawlRequestHandler implements RequestHandler {

    private final BackyardBoneBrawlGame game;

    public BackyardBoneBrawlRequestHandler() {
        this.game = new BackyardBoneBrawlGameImpl();
    }

    @Override
    public String handleRequest(HttpRequest request) {
        if (request.getMethod() == Method.GET) {
            switch (request.getUri()) {
                case "/gamestate":
                    return game.getGameState().toString();
                case "/playeryard":
                    return game.getPlayerYard();
                case "/cyberpupyard":
                    return game.getCyberPupYard();
            }
        } else if (request.getMethod() == Method.POST) {
            switch (request.getUri()) {
                case "/taketurn":
                    TurnResult turnResult = game.takeTurn(new YardCoordinate(request.getBody()));
                    return turnResult.toString();
            }
        }

        return null;
    }
}

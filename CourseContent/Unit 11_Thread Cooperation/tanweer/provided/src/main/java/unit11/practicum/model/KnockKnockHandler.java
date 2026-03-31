package unit11.practicum.model;

import unit11.httpserver.HttpRequest;
import unit11.httpserver.RequestHandler;

public class KnockKnockHandler implements RequestHandler {

    private static final int KNOCK_KNOCK = 0;
    private static final int WHO_IS_THERE = 1;
    private static final int PUNCH_LINE = 2;
    private int count;

    public KnockKnockHandler() {
        this.count = 0;
    }

    @Override
    public String handleRequest(HttpRequest request) {
        String response = "No more jokes.";
        switch(count) {
            case KNOCK_KNOCK:
                response = "Who's there?";
                break;
            case WHO_IS_THERE:
                response = request.getBody() + " who?";
                break;
            case PUNCH_LINE:
                response = "Ha ha, very funny.";
        }
        count++;
        return response;
    }
    
}

package unit11.practicum.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import unit11.httpserver.HttpRequest;

class KnockKnockHandlerTest {

    @Test
    void firstPartReturnsWhosThere() {
        // Setup
        KnockKnockHandler handler = new KnockKnockHandler();
        HttpRequest request = new HttpRequest(HttpRequest.Method.POST, "/", Map.of(), "Knock knock");

        // Invoke
        String response = handler.handleRequest(request);

        // Analysis
        assertEquals("Who's there?", response);
    }

    @Test
    void secondPartReturnsBodyPlusWho() {
        // Setup
        KnockKnockHandler handler = new KnockKnockHandler();

        HttpRequest firstRequest = new HttpRequest(HttpRequest.Method.POST, "/", Map.of(), "Knock knock");
        handler.handleRequest(firstRequest);

        HttpRequest secondRequest = new HttpRequest(HttpRequest.Method.POST, "/", Map.of(), "Boo");

        // Invoke
        String response = handler.handleRequest(secondRequest);

        // Analysis
        assertEquals("Boo who?", response);
    }

    @Test
    void thirdPartReturnsFinalPunchline() {
        // Setup
        KnockKnockHandler handler = new KnockKnockHandler();

        HttpRequest firstRequest = new HttpRequest(HttpRequest.Method.POST, "/", Map.of(), "Knock knock");
        handler.handleRequest(firstRequest);

        HttpRequest secondRequest = new HttpRequest(HttpRequest.Method.POST, "/", Map.of(), "Boo");
        handler.handleRequest(secondRequest);

        HttpRequest thirdRequest = new HttpRequest(HttpRequest.Method.POST, "/", Map.of(), "Why are you crying?");

        // Invoke
        String response = handler.handleRequest(thirdRequest);

        // Analysis
        assertEquals("Ha ha, very funny.", response);
    }
}

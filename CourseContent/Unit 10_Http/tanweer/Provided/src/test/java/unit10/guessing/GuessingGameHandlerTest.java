package unit10.guessing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Random;

import org.junit.jupiter.api.Test;

import unit10.httpserver.HttpRequest;
import unit10.httpserver.HttpRequestParser;
import unit10.httpserver.HttpStream;

public class GuessingGameHandlerTest {
    
    @Test
    public void testHandleReqeustQuit() {
        // Setup
        String requestStr = "POST / HTTP/1.1\r\n" +
                            "Content-Length: 4\r\n\r\n" +
                            "QUIT";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input); 
        
        
        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader); 

            // Invoke
            String actual = new GuessingGameHandler().handleRequest(request);

            // Verify
            assertEquals("GAME_OVER", actual);
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHandleReqeustRestart() {
        // Setup
        String requestStr = "POST / HTTP/1.1\r\n" +
                            "Content-Length: 7\r\n\r\n" +
                            "RESTART";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input); 
        
        
        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader); 

            // Invoke
            String actual = new GuessingGameHandler().handleRequest(request);

            // Verify
            assertEquals("RESTARTED", actual);
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHandleRequestGuessCorrect() {
        // Make the random number deterministic for this test so we can assert a specific response.
        try {
            Field rngField = GuessingGameImpl.class.getDeclaredField("RNG");
            rngField.setAccessible(true);
            Random rng = (Random) rngField.get(null);
            rng.setSeed(0);
        } catch (Exception e) {
            fail("Failed to set RNG seed: " + e.getMessage());
        }

        // Setup
        String requestStr = "POST / HTTP/1.1\r\n" +
                            "Content-Length: 8\r\n\r\n" +
                            "GUESS 61"; // with seed 0, the generated number is 61
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);

        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Invoke
            String actual = new GuessingGameHandler().handleRequest(request);

            // Verify
            assertEquals("CORRECT", actual);
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHandleRequestGuessTooLow() {
        // Make the random number deterministic (61) again.
        try {
            Field rngField = GuessingGameImpl.class.getDeclaredField("RNG");
            rngField.setAccessible(true);
            Random rng = (Random) rngField.get(null);
            rng.setSeed(0);
        } catch (Exception e) {
            fail("Failed to set RNG seed: " + e.getMessage());
        }

        // Setup: guess lower than the target (61)
        String requestStr = "POST / HTTP/1.1\r\n" +
                            "Content-Length: 7\r\n\r\n" +
                            "GUESS 1";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);

        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Invoke
            String actual = new GuessingGameHandler().handleRequest(request);

            // Verify
            assertEquals("TOO_LOW", actual);
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHandleRequestGuessTooHigh() {
        // Make the random number deterministic (61) again.
        try {
            Field rngField = GuessingGameImpl.class.getDeclaredField("RNG");
            rngField.setAccessible(true);
            Random rng = (Random) rngField.get(null);
            rng.setSeed(0);
        } catch (Exception e) {
            fail("Failed to set RNG seed: " + e.getMessage());
        }

        // Setup: guess higher than the target (61)
        String requestStr = "POST / HTTP/1.1\r\n" +
                            "Content-Length: 8\r\n\r\n" +
                            "GUESS 99";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);

        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Invoke
            String actual = new GuessingGameHandler().handleRequest(request);

            // Verify
            assertEquals("TOO_HIGH", actual);
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHandleRequestOutOfGuesses() {
        // Make the random number deterministic (61) again.
        try {
            Field rngField = GuessingGameImpl.class.getDeclaredField("RNG");
            rngField.setAccessible(true);
            Random rng = (Random) rngField.get(null);
            rng.setSeed(0);
        } catch (Exception e) {
            fail("Failed to set RNG seed: " + e.getMessage());
        }

        GuessingGameHandler handler = new GuessingGameHandler();

        try {
            // Use up all guesses with incorrect values
            for (int i = 0; i < GuessingGame.MAX_GUESSES; i++) {
                String requestStr = "POST / HTTP/1.1\r\n" +
                                    "Content-Length: 7\r\n\r\n" +
                                    "GUESS 1";
                InputStream input = new ByteArrayInputStream(requestStr.getBytes());
                HttpStream reader = new HttpStream(input);
                HttpRequest request = HttpRequestParser.parseRequest(reader);

                handler.handleRequest(request);
            }

            // One more guess should return OUT_OF_GUESSES
            String requestStr = "POST / HTTP/1.1\r\n" +
                                "Content-Length: 7\r\n\r\n" +
                                "GUESS 1";
            InputStream input = new ByteArrayInputStream(requestStr.getBytes());
            HttpStream reader = new HttpStream(input);
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            String actual = handler.handleRequest(request);
            assertEquals("OUT_OF_GUESSES", actual);
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHandleRequestUnknownCommand() {
        // Setup
        String requestStr = "POST / HTTP/1.1\r\n" +
                            "Content-Length: 7\r\n\r\n" +
                            "UNKNOWN";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);

        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Invoke
            String actual = new GuessingGameHandler().handleRequest(request);

            // Verify
            assertTrue(actual.startsWith("ERROR: Unknown Command - "));
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testHandleRequestNonPostMethod() {
        // Setup
        String requestStr = "GET / HTTP/1.1\r\n" +
                            "Content-Length: 4\r\n\r\n" +
                            "QUIT";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);

        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Invoke
            String actual = new GuessingGameHandler().handleRequest(request);

            // Verify
            assertNull(actual);
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

}

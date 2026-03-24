package unit10.httpserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;



/**
 * Unit tests for HTTPRequestParser. 
 * Tests are designed for incremental development. 
 * First test only needs first line to pass.
 * Second test needs first line and parseHeaders to pass.
 * Third test needs full implementation to pass.
 */
public class HttpRequestParserTest {

    @Test
    public void testParseRequestEmpty() {
        // Setup
        String requestStr = "GET / HTTP/1.1\r\n\r\n";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);  
        
        // Invoke
        try {
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Verify
            assertEquals("GET", request.getMethod().toString());
            assertEquals("/", request.getUri());
            assertEquals(null, request.getHeader("Host"));
            assertEquals(null, request.getBody());
            assertEquals("HTTPRequest {method: GET, uri: /, headers: {}, body: null}", request.toString());
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testParseRequestGET() {
        // Setup
        String requestStr = "GET /index.html HTTP/1.1\r\n" +
                            "Host: localhost\r\n" +
                            "User-Agent: TestClient\r\n" +
                            "\r\n";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);

        // Execute
        try {
             HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Verify
            assertEquals("GET", request.getMethod().toString());
            assertEquals("/index.html", request.getUri());
            assertEquals("localhost", request.getHeader("host"));
            assertEquals("TestClient", request.getHeader("user-agent"));
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    public void testParseRequestPOST() {
        // Setup
        String requestStr = "POST /submit HTTP/1.1\r\n" +
                            "Host: localhost\r\n" +
                            "Content-Length: 11\r\n" +
                            "\r\n" +
                            "Hello World";
        InputStream input = new ByteArrayInputStream(requestStr.getBytes());
        HttpStream reader = new HttpStream(input);

        // Execute
        try {
             HttpRequest request = HttpRequestParser.parseRequest(reader);

            // Verify
            assertEquals("POST", request.getMethod().toString());
            assertEquals("/submit", request.getUri());
            assertEquals("localhost", request.getHeader("host"));
            assertEquals("11", request.getHeader("content-length"));
            assertEquals("Hello World", request.getBody());
        } catch (Exception e) {
            fail ("Exception should not be thrown: " + e.getMessage());
        }
    }

}

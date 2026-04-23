package unit13.httpserver;

import java.util.Arrays;

/** 
 * Canned response messages
 */

public class HttpResponseBuilder {

    /**
     * Returns a valid OK response for the provided content.
     * @param content - HTTP body
     * @return String version of the HTTP repsonse
     */
    public static String buildSuccessResponse(String content) {
        return "HTTP/1.1 200 OK\r\n" 
                + "Access-Control-Allow-Origin: *\r\n"
                + "Content-Length: " + content.length() + "\r\n"
                + "Content-Type: text/html; charset=utf-8\r\n\r\n"
                + content;
    }  
    
    /**
     * Returns a valid No Content response. Allows any numbers of headers
     * to be validated as part of the response.
     * 
     * Example: buildNoContentResponse ("session-id", "debug-enabled") would
     * create a response the looks like:
     * 
     * HTTP/1.1 204 No Content
     * Access-Control-Allow-Origin: *
     * Access-Control-Allow-Headers: session-id
     * Access-Control-Allow-Headers: debug-enabled
     * 
     * 
     * Works with no aruments as well which would create the message:
     * 
     * HTTP/1.1 204 No Content
     * Access-Control-Allow-Origin: *
     * 
     * @return String version of the HTTP response
     */
    public static String buildNoContentResponse(String ... validHeaders) {
        return "HTTP/1.1 204 No Content\r\n"
                + "Access-Control-Allow-Origin: *\r\n" 
                + (validHeaders != null ? 
                    String.join("\r\n", Arrays.stream(validHeaders)
                          .map(s -> "Access-Control-Allow-Headers: " + s)
                          .toList()) : "") 
                + "\r\n\r\n";
    }
    
    /**
     * Retuns a valid Bad Request error response.
     * @param message - Error message associated with the failure.
     * @return String version of the HTTP repsonse
     */
    public static String buildErrorResponse(String message) {
        return "HTTP/1.1 400 Bad Request\r\n"
                + "Access-Control-Allow-Origin: *\r\n"
                + "Content-Length: " + message.length() + "\r\n"
                + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
                + message;
    }
}

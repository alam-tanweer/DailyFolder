package unit10.httpserver;

public class demo implements RequestHandler {

    @Override
    public String handleRequest(HttpRequest request) {
        if (request.getMethod() == HttpRequest.Method.GET && request.getUri().equals("/")) {
            return "Welcome to the Demo HTTP Server!";
        } else {
            return "404 Not Found: " + request;
        }
    }

    public static void main(String[] args) {
        // FirstSimpleHttpWebServer server = new FirstSimpleHttpWebServer(8001, new demo());
        // server.start();
    }
}


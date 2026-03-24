package unit10.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SimpleHttpWebServer {
    private final int port;

    public SimpleHttpWebServer(int port) {
        this.port = port;
    }

    private void sendResponse(PrintWriter writer, String response) throws IOException {
        writer.println(response);
        writer.flush();
        System.out.println("Response: " + response);
    }

    private String handleRequest(HttpRequest request) {

        if (!request.getUri().equals("/"))
            return null;
        
        return "Request Received.";

    }

    public void handleClient(Socket clientSocket) throws IOException {
        try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                HttpStream reader = new HttpStream(clientSocket.getInputStream())) {

            HttpRequest request = HttpRequestParser.parseRequest(reader);
            System.out.println("Incoming Request=: " + request);

            String response = handleRequest(request);
            System.out.println("Outgoing Response=: " + response);

            if (response == null) {
                sendResponse(writer, HttpResponseBuilder.buildNotFoundErrorResponse(request.getUri() + " not found"));
            } else {
                sendResponse(writer, HttpResponseBuilder.buildSuccessResponse(response));
            }

            clientSocket.close();

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            throw e;
        }
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Listening on " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleHttpWebServer server = new SimpleHttpWebServer(8081);
        server.start();
    }
}

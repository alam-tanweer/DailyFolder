package unit10.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Activities 10.16 and 10.17
 */

import unit10.guessing.GuessingGameHandler;

public class ThirdHttpWebServer {
    
    private final int port;
    private final Map<String, RequestHandler> handlers;
    private static final String SESSION_ID = "x-session-id";

    public ThirdHttpWebServer(int port) {
        this.port = port;
        handlers = new HashMap<>();
    }

    private void sendResponse(PrintWriter writer, String response) throws IOException {
        writer.println(response);
        writer.flush();
        System.out.println("Response: " + response);
    }

    public void handleClient(Socket clientSocket) throws IOException {
        try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
            HttpStream reader = new HttpStream(clientSocket.getInputStream())) {
            HttpRequest request = HttpRequestParser.parseRequest(reader);

            if (request.getMethod() == HttpRequest.Method.OPTIONS) {
                sendResponse(writer, HttpResponseBuilder.buildOptionsResponse());
                return;
            }

            RequestHandler handler = null;
            String clientId = request.getHeader(SESSION_ID);
            if (handlers.containsKey(clientId)) {
                handler = handlers.get(clientId);
            }else {
                handler = new GuessingGameHandler();
                handlers.put (clientId, handler);
            }

            String response = handler.handleRequest(request);
            if (response == null) {
                sendResponse(writer,HttpResponseBuilder.buildNotFoundErrorResponse(request.getUri() + " not found"));
            } else {
                sendResponse(writer,HttpResponseBuilder.buildSuccessResponse(response));
            }
            
            // clientSocket.close();

        } catch (IOException e) {
            System.err.println("ERROR: " + e.getMessage());
            throw e;
        }
    }
    
    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Listening on " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


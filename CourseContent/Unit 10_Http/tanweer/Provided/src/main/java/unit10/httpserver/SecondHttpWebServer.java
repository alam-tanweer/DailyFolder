package unit10.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class SecondHttpWebServer {
    
    private final int port;
    private final RequestHandler handler;

    public SecondHttpWebServer(int port, RequestHandler handler) {
        this.port = port;
        this.handler = handler;
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
            
            String response = handler.handleRequest(request);
            if (response == null) {
                sendResponse(writer,HttpResponseBuilder.buildNotFoundErrorResponse(request.getUri() + " not found"));
            } else {
                sendResponse(writer,HttpResponseBuilder.buildSuccessResponse(response));
            }
            
            clientSocket.close();

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


package unit11.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/** 
 * Activity 10.18 
 */

public class HttpWebServer {
    
    private final int port;
    private final Supplier<RequestHandler> supplier;
    private final Map<String, RequestHandler> handlers;
    private static final String SESSION_ID = "x-session-id";

    //11.7
    private final Lock handlersLock;

    public HttpWebServer(int port, Supplier<RequestHandler> handler) {
        this.port = port;
        this.supplier = handler;
        handlers = new HashMap<>();
        //11.7
        handlersLock = new ReentrantLock();
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
                sendResponse(writer, HttpResponseBuilder.buildNoContentResponse(SESSION_ID));
                return;
            } else if (request.getUri().contains("favicon.ico")) {
                sendResponse(writer, HttpResponseBuilder.buildNoContentResponse(SESSION_ID));
                return;
            }

            RequestHandler handler = null;
            String clientId = request.getHeader("x-session-id");
            //11.7
            handlersLock.lock();
            try {
                if (handlers.containsKey(clientId)) {
                    handler = handlers.get(clientId);
                } else {
                    handler = this.supplier.get();
                    handlers.put(clientId, handler);
                }
            } finally {
                //11.7
                handlersLock.unlock();
            }

            String response = handler.handleRequest(request);
            if (request.getUri().contains("favicon.ico")) {
                sendResponse(writer, HttpResponseBuilder.buildNoContentResponse());
            }
            else if (response == null) {
                sendResponse(writer,HttpResponseBuilder.buildErrorResponse("404 Not Found: " + request.getUri()));
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
        //11.7
        ExecutorService executor = Executors.newCachedThreadPool();

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Listening on " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleClient(clientSocket);
                
                //11.7
                // executor.submit(() -> {
                //     try {
                //         handleClient(clientSocket);
                //     } catch (IOException e) {
                //         // TODO Auto-generated catch block
                //         e.printStackTrace();
                //     }
                // });

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


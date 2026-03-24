package unit10.httpserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstHttpWebServer {
    
    private final int port;

    private static final String DRINKING_DAY = "2005-03-07"; // Drinking birthday on the day I wrote this code
    private static final boolean BASIC = true;

    private static final String BASIC_YES = "Congratulations! You are old enough to drink.";
    private static final String BASIC_NO = "Sorry, you are not old enough to drink.";

    private static final String HTML_YES = "<html><body><h1>Congratulations!</h1><p>You are old enough to drink.</p></body></html>";
    private static final String HTML_NO = "<html><body><h1>Sorry!</h1><p>You are not old enough to drink.</p></body></html>"; 

    public FirstHttpWebServer(int port) {
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

        Map<String, Integer> birthday = Arrays.stream(request.getBody().split("&"))
            .map(param -> param.split("="))
            .collect(Collectors.toMap(pair -> pair[0], pair -> Integer.parseInt(pair[1])));
        
        String birthDate = String.format("%04d-%02d-%02d", birthday.get("year"), 
            birthday.get("month"), birthday.get("day"));
        String content;
        if (birthDate.compareTo(DRINKING_DAY) >= 0) {
            content = BASIC ? BASIC_NO : HTML_NO;
        } else {
            content = BASIC ? BASIC_YES : HTML_YES;
        }

        return content;       
        
    }

    public void handleClient(Socket clientSocket) throws IOException {
        try (PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             HttpStream reader = new HttpStream(clientSocket.getInputStream())) {
            HttpRequest request = HttpRequestParser.parseRequest(reader);
            
            String response = handleRequest(request);
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

    public static void main(String[] args) {
        FirstHttpWebServer server = new FirstHttpWebServer(8081);
        server.start();
    }
}


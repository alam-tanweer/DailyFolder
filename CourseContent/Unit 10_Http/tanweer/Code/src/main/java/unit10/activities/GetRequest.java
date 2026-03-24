package unit10.activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import unit10.httpserver.HttpStream;

public class GetRequest {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Server is listening on port 8081");
            Socket clientSocket = serverSocket.accept();
            HttpStream httpStream = new HttpStream(clientSocket.getInputStream());
            httpStream.lines().forEach(System.out::println);
            
            // // for post request - Can I Drink
            System.out.println(httpStream.readChars(25));

            // //10.2

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // String content = "My First Webpage!";
            String content = "<html><body><h1>My First Webpage!</h1></body></html>";
            String response = "HTTP/1.1 200 OK\r\n" 
                    + "Content-Length: " + content.length() + "\r\n"
                    // + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
                    + "Content-Type: text/html; charset=utf-8\r\n\r\n"
                    + content
                    + "\r\n\r\n";

            out.print(response);
            out.flush();

            // 10.2
            out.close ();

            httpStream.close();

        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }
}

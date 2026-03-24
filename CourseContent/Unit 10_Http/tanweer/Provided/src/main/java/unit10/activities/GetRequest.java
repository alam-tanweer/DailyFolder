package unit10.activities;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import unit10.httpserver.HttpStream;

/**
 * Activities 10.1 and 10.2
 */

public class GetRequest {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            System.out.println("Server is listening on port 8081");
            Socket clientSocket = serverSocket.accept();
            HttpStream httpStream = new HttpStream(clientSocket.getInputStream());
            httpStream.lines().forEach(System.out::println);
            System.out.println(httpStream.readChars(100));

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String content = "My First Webpage!";
            String response = "HTTP/1.1 200 OK\r\n" 
                    + "Content-Length: " + content.length() + "\r\n"
                    + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
                    + content
                    + "\r\n\r\n";

            out.print(response);
            out.flush();
            httpStream.close();
            out.close ();
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }
}

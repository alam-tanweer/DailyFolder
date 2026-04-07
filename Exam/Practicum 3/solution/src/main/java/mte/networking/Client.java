package mte.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(HOST, PORT);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.println("Connected to server on port " + PORT);

            while (true) {
                System.out.print("Either enter a value or Type EXIT to end: ");
                String input = userInput.readLine();

                if (input == null) {
                    break;
                }

                serverOutput.println(input);

                if ("EXIT".equalsIgnoreCase(input.trim())) {
                    break;
                }
            }

            // ✅ Read all server responses until connection closes
            String responseLine;
            System.out.println("\n--- Server Response ---");
            while ((responseLine = serverInput.readLine()) != null) {
                System.out.println(responseLine);
            }

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}

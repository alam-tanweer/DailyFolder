package mte.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {
        int port = 12345;
        String address = "localhost";

        Socket socket = new Socket(address, port);
        Scanner inputStream = new Scanner(socket.getInputStream());
        PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);

        // prompt the user for the input
        while (true) { 
            Scanner scanner = new Scanner(System.in);

            System.out.print(">>> ");

            String user_input = scanner.nextLine();
            outputStream.println(user_input);

            if (user_input.toLowerCase().equals("exit")) {
                // receive all the messages from the server
                do {
                    System.out.println(inputStream.nextLine());
                } while (inputStream.hasNextLine());

                // close everything
                socket.close();
                scanner.close();
                inputStream.close();
                outputStream.close();
                break;
            }
        }
    }
}

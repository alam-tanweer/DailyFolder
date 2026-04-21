package mte.networking;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",12345);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());

        Scanner input = new Scanner(System.in);
        String text = "";
        while(!text.strip().toLowerCase().equals("exit")){
            System.out.println("Enter a value or Type EXIT to end: ");
            text = input.nextLine();
            writer.println(text);
            writer.flush();
        }
        String serverResponse = in.readLine();
        System.out.println(serverResponse);
        serverResponse = in.readLine();
        System.out.println(serverResponse);
        socket.close();
        writer.close();
        input.close();
        in.close();
    }
}

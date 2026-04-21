package mte.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {
        try{
            String message = "";
            Socket client = new Socket("localhost",12345);
            while (true){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a value or Type Exit to end: ");
                message = sc.nextLine();
                OutputStream out = client.getOutputStream();
                PrintWriter printer = new PrintWriter(out);
                printer.println(message);
                printer.flush();

                if (message.equalsIgnoreCase("exit")){
                    InputStream input = client.getInputStream();
                    InputStreamReader in = new InputStreamReader(input);
                    BufferedReader reader = new BufferedReader(in);
                    String text = reader.readLine();
                    System.out.println(text);
                    client.close();
                    sc.close();
                    break;
                }
            }

        } catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

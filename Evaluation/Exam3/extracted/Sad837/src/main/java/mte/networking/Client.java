package mte.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args){
        //Connect to the server
        try(
            Socket client = new Socket("localhost",12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            //get user input and send to server until EXIT is typed
            Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value or Type EXIT to end: ");

        String text = scanner.next();
        while(!"EXIT".equalsIgnoreCase(text.trim())){
            System.out.println("Enter a value or Type EXIT to end: ");
            out.println(text);
            out.flush();
            text = scanner.next();

        }
        scanner.close();
        
        
        in.lines().forEach(System.out::println);


        //close resources
        in.close();
        scanner.close();
        out.close();
        client.close();

        } catch (IOException e) {
             System.err.println("Client handling error: " + e.getMessage());
        }
                
                

        
        
        

    }
}

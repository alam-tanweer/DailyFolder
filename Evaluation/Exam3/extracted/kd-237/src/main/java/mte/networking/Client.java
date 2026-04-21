package mte.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws UnknownHostException, IOException {
        try (Socket skt = new Socket("localhost", 12345)) {
            System.out.println("Connected to serve");
            
            PrintWriter out = new PrintWriter(skt.getOutputStream());

             BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));

             Scanner sc = new Scanner(System.in);
            while (true) {
                
             while(true){
                System.out.println("Enter a value or type EXIT to end");
                String msg1 = sc.nextLine();

                System.out.println("Enter a value or type EXIT to end");
                String msg2 = sc.nextLine();

                if(msg1.equals("Exit")){
                    break;
                }
                if(msg2.equals("Exit")){
                    break;
                }

                out.println(msg1.toUpperCase());
                out.println(msg2.toUpperCase());

                out.flush();

             }

             String br = in.readLine();
             System.out.println("Message from server: " + br);
            }
            // skt.close(); 
            // sc.close(); 
            // in.close();
            // out.close();
        } 
    }      
} 

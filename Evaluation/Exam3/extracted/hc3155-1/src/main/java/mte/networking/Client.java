package mte.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost", 12345);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        Scanner local = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = "";
        while(true){
            System.out.print("Either enter a value or Type EXIT to end: ");
            String input = local.nextLine();
            pw.println(input);
            pw.flush();
            if(input.toUpperCase().equals("EXIT")){
                String line;
                while((line=in.readLine()) != null){
                    System.out.println(line);
                }
                break;
            }
        }
        socket.close();
        pw.close();
        local.close();
    }
}

package mte.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {
        try{
        Socket socket = new Socket("localhost",12345);
        
        System.out.println("Connected. ");

        String message = "";
        List<String> messages = new ArrayList<>();
        int index = 0;
        while(!message.toUpperCase().equals("EXIT")){
            System.out.println("Either enter a value or type EXIT to end: ");
            Scanner scanner = new Scanner(System.in);
            message = scanner.nextLine();
            
            OutputStream out = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(out);
            pw.println(message);
            pw.flush();
            
            
            
        }
        
        
        InputStream i = socket.getInputStream();
        InputStreamReader in = new InputStreamReader(i);
        BufferedReader br = new BufferedReader(in);
        for(int line=0; line<2; line++){
        messages.add(br.readLine());
        }
        socket.close();

        

        




        for (String m : messages){
            System.out.println(m);

        }







        } catch (IOException e){
            e.printStackTrace();
        }
        
        
        
    }
}

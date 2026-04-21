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
        Socket client = new Socket("localhost", 12345);

        PrintWriter out = new PrintWriter(client.getOutputStream(),true);
        BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));

        Scanner in = new Scanner(System.in);

        String line = "";

        while(!"EXIT".equalsIgnoreCase(line.trim())){
            System.out.println("Either enter a value or Type EXIT to end: ");
            line = in.nextLine();
            out.println(line);
        }

        String inLine;

        while(true){
            inLine = input.readLine();
            if(inLine == null){
                client.close();
                out.close();
                input.close();

                break;
            }
            System.out.println(inLine);
        }
    }
}

package mte.networking;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {
        try  (
            Socket client = new Socket("localhost", 12345);
            Scanner scanner = new Scanner(System.in);
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            Scanner in = new Scanner(client.getInputStream());
        )

        {
            while (true) {
                System.out.println("Either enter a value or Type EXIT to end:");
                String msg = scanner.nextLine();
                out.println(msg);
                if (msg.toLowerCase().equals("exit")) {
                    while (in.hasNext()) {
                        System.out.println(in.next());
                    }
                    break;
                }
            }
        }

        catch (Exception e) {}
    }
}

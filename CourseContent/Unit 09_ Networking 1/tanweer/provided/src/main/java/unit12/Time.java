package unit12;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Time {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket ("time.nist.gov", 13);
        InputStream input = client.getInputStream ();
        Scanner sc = new Scanner (input);
        while (sc.hasNext()) {
            String message = sc.next ();
            System.out.print (message + " ");   
        }
        sc.close();
        client.close();
        System.out.println ();
    }
}

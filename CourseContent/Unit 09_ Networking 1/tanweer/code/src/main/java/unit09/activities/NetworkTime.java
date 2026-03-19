package unit09.activities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class NetworkTime {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket ("time.nist.gov", 13);
        InputStream input = client.getInputStream ();

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));


        // String line = "";
        // while((line = reader.readLine()) != null ){
        //     System.out.println(line);
        // }

        //It is a blocker. Wait till all data is read and socket is closed. If you need to process each line one by one, 
        //Continue to establish connection Don't use it.
        reader.lines().forEach(System.out::println);

        
        // //Scanner version
        // Scanner sc = new Scanner (input);
        // while (sc.hasNext()) {
        //     String message = sc.next ();
        //     System.out.print (message + " ");   
        // }
        // sc.close();

        client.close();
        System.out.println ();
    }
}

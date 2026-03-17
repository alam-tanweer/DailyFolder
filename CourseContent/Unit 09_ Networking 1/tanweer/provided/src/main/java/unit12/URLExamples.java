package unit12;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLExamples {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.nsa.gov");
        URLConnection connection = url.openConnection();
        connection.connect();

        InputStream in = connection.getInputStream();
        Scanner scanner = new Scanner(in);

        while(scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
        
        scanner.close();
    }
}

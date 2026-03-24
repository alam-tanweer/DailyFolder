package unit10;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Name {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket ("129.21.157.50", 12345);
        OutputStream output = client.getOutputStream ();
        PrintWriter printer = new PrintWriter (output);
        printer.println ("Bruce Herring"); 
        printer.flush ();
        client.close ();
    }
}

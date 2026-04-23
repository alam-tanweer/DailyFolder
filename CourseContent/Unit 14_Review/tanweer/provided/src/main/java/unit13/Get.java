package unit13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Get {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket( "www.google.org", 80 );
        // Socket sock = new Socket( "localhost", 8080 );
        String request = "GET / HTTP/1.1\r\n" +
            "Host: www.google.com\r\n" + 
            "Connection: close\r\n\r\n";
        OutputStream out = sock.getOutputStream();
        out.write( request.getBytes());
        out.flush();
        InputStream in = sock.getInputStream();
        byte[] buf = new byte[10240];
        int n;
        while(( n = in.read( buf )) > 0 ) {
            String response = new String( buf, 0, n );
            System.out.println( response );
        }
        sock.close();
    }
    
}

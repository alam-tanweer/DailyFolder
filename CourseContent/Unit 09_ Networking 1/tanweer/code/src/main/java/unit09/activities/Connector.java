package unit09.activities;

import java.io.IOException;
import java.net.Socket;

public class Connector {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("www.npr.org", 443);
        sock.close();
    }
}

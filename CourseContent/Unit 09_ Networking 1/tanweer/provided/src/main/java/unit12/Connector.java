package unit12;

import java.io.*;
import java.net.*;

public class Connector {
    public static void main(String[] args) throws IOException{
        Socket sock = new Socket("www.npr.org", 443);
        sock.close();
    }
}

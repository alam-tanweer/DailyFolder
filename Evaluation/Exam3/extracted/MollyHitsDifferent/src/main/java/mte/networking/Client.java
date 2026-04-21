package mte.networking;

import java.io.BufferedReader;
import java.io.IO;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.*;

public class Client {
    // private static final int PORT = 12345;
    // // private Socket socket;
    // private PrintWriter writer;
    // private OutputStream stream;
    // private InputStream serverStream;

    // Client(InputStream inputStream) {
    // this.socket = new Socket("Localhost",12345);
    // try {
    // this.stream = socket.getOutputStream();
    // } catch (IOException E) {
    // E.printStackTrace();
    // }
    // this.writer = new PrintWriter(this.stream);
    // this.serverStream = inputStream;
    // this.writer = new PrintWriter(this.stream);

    // }
    // @Override
    // public void run() {
    // Client client = new Client(serverStream);
    // SocketAddress SA = "127.0.0.1";
    // socket.connect(Localhost, 12345);
    // }
   
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        InputStream input = socket.getInputStream(); 
        BufferedReader reader = new BufferedReader(input);
        socket.close();

    }
}

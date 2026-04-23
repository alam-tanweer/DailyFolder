package duplexer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Duplexer {
    private Socket socket;
    private Scanner in;
    private PrintWriter out;

    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new PrintWriter(socket.getOutputStream());
        this.in = new Scanner(socket.getInputStream());
    }

    public void send(String message) {
        out.println(message);
        out.flush();
    }

    public String receive() {
        return in.nextLine();
    }

    public void close() throws IOException {
        out.close();
        out.close();
        socket.close();
    }
}
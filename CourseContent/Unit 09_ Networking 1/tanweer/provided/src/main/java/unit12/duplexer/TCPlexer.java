package unit12.duplexer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCPlexer extends Duplexer {
    private final Socket socket;
    private final Scanner scanner;
    private final PrintWriter writer;

    public TCPlexer(Socket socket) throws IOException {
        this(socket, false);
    }

    public TCPlexer(Socket socket, boolean debug) throws IOException {
        super(debug);
        this.socket = socket;
        this.scanner = new Scanner(socket.getInputStream());
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void close() throws Exception {
        scanner.close();
        writer.close();
        socket.close();
    }

    @Override
    public void send(String message) {
        debug(">> " + message);
        writer.println(message);
        writer.flush();
    }

    @Override
    public String receive() {
        String message = scanner.nextLine();
        debug("<< " + message);
        return message;
    }
}

package unit10.duplexer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPlexer extends Duplexer {
    private final DatagramSocket socket;
    private InetAddress address;
    private int port;

    public UDPlexer(DatagramSocket socket) {
        this(socket, false);
    }

    public UDPlexer(DatagramSocket socket, boolean debug) {
        this(socket, null, -1, debug);
    }

    public UDPlexer(DatagramSocket socket, InetAddress address, int port) {
        this(socket, address, port, false);
    }

    public UDPlexer(DatagramSocket socket, InetAddress address, int port, 
                    boolean debug) {
        super(debug);
        this.socket = socket;
        this.address = address;
        this.port = port;
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }

    @Override
    public void send(String message) {
        debug(">> " + message);
        byte[] bytes = message.getBytes();
        DatagramPacket outgoing 
            = new DatagramPacket(bytes, bytes.length, address, port);
        try {
            socket.send(outgoing);
        } catch (IOException e) {}
    }

    @Override
    public String receive() {
        byte[] bytes = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(bytes, bytes.length);
        try {
            socket.receive(incoming);
            byte[] data = incoming.getData();
            int length = incoming.getLength();
            this.address = incoming.getAddress();
            this.port = incoming.getPort();
            String message = new String(data, 0, length);
            debug("<< " + message);
            return message;
        } catch (IOException e) {
            return null;
        }
    }
}

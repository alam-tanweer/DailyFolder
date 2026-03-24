package unit10.assignment1.intersection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SIServer {
    private DatagramSocket socket;
    private DatagramPacket packetIn;
    private Set<String> set;
    private Set<String> intersection;
    private static final String NO = "NO";
    private static final String END = "END";

    public SIServer(int PORT, Set<String> set) throws IOException {
        socket = new DatagramSocket(PORT);
        intersection = new HashSet<>();
        this.set = new HashSet<>(set);
    }

    public String receive() throws IOException {
        byte[] receivedBuf = new byte[1024];
        packetIn = new DatagramPacket(receivedBuf, receivedBuf.length);
        socket.receive(packetIn);
        String receivedMssage = new String(packetIn.getData(), 0, packetIn.getLength());
        return receivedMssage;
    }

    public void send(String message) throws IOException {
        byte[] buf = message.getBytes();
        DatagramPacket packetOut = new DatagramPacket(buf, buf.length, packetIn.getAddress(), packetIn.getPort());
        socket.send(packetOut);
    }

    public void close() {
        socket.close();
    }

    public void mainLoop() throws IOException {
        String prevMsg = null;
        while (true) {
            // receive
            String receivedMsg = receive();

            if (receivedMsg.equals(NO)) {
                receivedMsg = receive();
            } else {
                if (prevMsg != null) {
                    intersection.add(prevMsg);
                }
            }
            if (receivedMsg.equals(END)) {
                break;
            }
            // send
            if (set.remove(receivedMsg)) {
                intersection.add(receivedMsg);
            } else {
                send(NO);
            }
            if (set.isEmpty()) {
                send(END);
                break;
            } else {
                for (String item : set) {
                    send(item);
                    prevMsg = item;
                    set.remove(item);
                    break;
                }
            }
        }
    }

    public Set<String> intersection() {
        return this.intersection;
    }

    public static void main(String[] args) throws IOException {
        SIServer server = new SIServer(54321, Sets.B4());
        System.out.println("Server is waiting...");
        server.mainLoop();
        Set<String> intersection = new TreeSet<>(server.intersection());
        System.out.println(intersection);
        System.out.println("Size = " + intersection.size());
        System.out.println("Server is closing...");
        server.close();
    }
}

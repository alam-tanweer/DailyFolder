package unit12.assignment1.intersection;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SIClient {
    private final int PORT;
    private final String SERVER_NAME;
    DatagramSocket socket;
    private Set<String> set;
    private Set<String> intersection;
    private static final String NO = "NO";
    private static final String END = "END";

    public SIClient(String SERVER_NAME, int PORT, Set<String> set) throws IOException {
        this.socket = new DatagramSocket();
        this.PORT = PORT;
        this.SERVER_NAME = SERVER_NAME;
        intersection = new HashSet<>();
        this.set = new HashSet<>(set);
    }

    public String receive() throws IOException {
        byte[] receivedBuf = new byte[1024];
        DatagramPacket packetIn = new DatagramPacket(receivedBuf, receivedBuf.length);
        socket.receive(packetIn);
        String receivedMssage = new String(packetIn.getData(), 0, packetIn.getLength());
        return receivedMssage;
    }

    public void send(String message) throws IOException {
        byte[] buf = message.getBytes();
        DatagramPacket packetOut = new DatagramPacket(buf, buf.length,
                InetAddress.getByName(SERVER_NAME), PORT);
        socket.send(packetOut);
    }

    public void close() {
        socket.close();
    }

    public Set<String> intersection() {
        return intersection;
    }

    private String sendAndRemove() throws IOException {
        if (!set.isEmpty()) {
            for (String item : set) {
                send(item);
                set.remove(item);
                return item;
            }
        } else {
            send(END);
        }
        return null;
    }

    public void mainLoop() throws IOException {

        String prevMsg = sendAndRemove();
        while (prevMsg != null) {
            // receive
            String receivedMsg = receive();

            if (receivedMsg.equals(NO)) {
                receivedMsg = receive();
            } else {
                intersection.add(prevMsg);
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
            prevMsg = sendAndRemove();
        }
    }

    public static void main(String[] args) throws IOException {
        SIClient client = new SIClient("localhost", 54321, Sets.A4());
        client.mainLoop();

        Set<String> intersection = new TreeSet<>(client.intersection());
        System.out.println(intersection);
        System.out.println("Size = " + intersection.size());
        System.out.println("Client is closing...");
        client.close();

    }
}

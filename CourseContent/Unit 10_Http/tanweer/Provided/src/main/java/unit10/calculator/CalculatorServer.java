// Starter code for Activity: Calculator Server

package unit10.calculator;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides a simple, single-threaded implementation of a calculator server.
 * Allows one client to connect and perform a single operation.
 */
public class CalculatorServer {
    /**
     * The supported calculator operations.
     */
    private static final List<BinaryOperation> OPERATIONS = new ArrayList<>(7);
    static {
        OPERATIONS.add(new Addition());
        OPERATIONS.add(new Subtraction());
        OPERATIONS.add(new Multiplication());
        OPERATIONS.add(new Division());
        OPERATIONS.add(new FloorDivision());
        OPERATIONS.add(new Exponent());
    }

    /**
     * The main server code. Allows one client to connect and send a single
     * request.
     *
     * @param args Ignored.
     * @throws IOException If there are any problems communicating with the
     * client.
     */
    public static void main (String[] args) throws IOException {
        Calculator calculator = new Calculator (OPERATIONS);
        try(DatagramSocket dsock = new DatagramSocket (12400)) {
            byte[] data = new byte [1024];
            DatagramPacket operation = new DatagramPacket (data, data.length);

            for (;;) {
                dsock.receive(operation);
                String request = new String (data, 0, operation.getLength());
                String[] tokens = request.strip().split(" ");

                String response;
                if (tokens.length < 3) {
                    response = "error bad request";
                } else {
                    try {
                        float operand1 = Float.parseFloat(tokens[0]);
                        float operand2 = Float.parseFloat(tokens[2]);
                        response = "" + calculator.calculate(tokens[1], operand1, operand2);
                    } catch (Exception iae) {
                        response = "error " + iae.getLocalizedMessage();
                    }
                }
                System.out.println(response);

                byte[] outgoing = response.getBytes ();
                DatagramPacket packet = new DatagramPacket (outgoing, outgoing.length,
                    operation.getAddress(), operation.getPort());
                dsock.send (packet);
            }
        }
    }
}

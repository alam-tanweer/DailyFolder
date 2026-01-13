package unit01.spring2021.assignment3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class SieveMaker {
    /**
     * Used to pick an element in the sieve to toggle.
     */
    private static final Random RNG = new Random(1);

    /**
     * Makes a Sieve of Eratosthenes. The sieve is an int array where 0 
     * represents a prime number and 1 represents a non-prime.
     * 
     * @param size The size of the sieve to make.
     * 
     * @return The Sieve of Eratosthenes of the specified size.
     */
    public static int[] makeSieve(int size) {
        int[] sieve = new int[size];

        sieve[0] = 1;
        sieve[1] = 1;

        for(int i=2; i<size; i++) {
            if(sieve[i] == 0) {
                for(int n=2; n*i<size; n++) {
                    sieve[n*i] = 1;
                }
            }
        }

        return sieve;
    }

    public static void writeSieve(int size, String filename) 
        throws IOException {
        writeSieve(size, filename, 10, false);
    }

    public static void writeSieve(int size, String filename, 
        int columns, boolean corrupt) throws IOException {

        int[] sieve = makeSieve(size);

        // toggles a single value somewhere in the sieve
        if(corrupt) {
            int randomIndex = RNG.nextInt(size);
            sieve[randomIndex] = sieve[randomIndex] == 1 ? 0 : 1;
        }

        try(FileWriter fWriter = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(fWriter)) {
            writer.print(size);
            for(int i=0; i<size; i++) {
                if(i % columns == 0) {
                    writer.println();
                }
                writer.print(sieve[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        if(args.length != 4) {
            System.err.println("Usage: java Sievemaker <size> <filename> " 
                + "<columns> <corrupt>");
            System.exit(1);
        }
        int size = Integer.parseInt(args[0]);
        String filename = args[1];
        int columns = Integer.parseInt(args[2]);
        boolean corrupt = args[3].equalsIgnoreCase("true");

        writeSieve(size, filename, columns, corrupt);
    }
}
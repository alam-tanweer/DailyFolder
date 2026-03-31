/**
 * Original prototype for this activity. Not used anymore but kept
 * it as reference material.
 */

package unit11.assignment2.pi;

import org.apfloat.Apfloat;

public class PI {
    private static final int NUM_THREADS = 20;
    private static final long CHUNK_SIZE = 1000000l;
    private static Apfloat[] parts = new Apfloat [NUM_THREADS];

    static private Apfloat calculateTerm (long n) {
        double s = n * 2;
        Apfloat num = new Apfloat (4 * Math.pow (-1, (n + 1) % 2), 100);
        Apfloat denom = new Apfloat (s * (s + 1) * (s + 2), 100);
        return num.divide (denom);
    }

    private static void calculatePiPortion (long start, long stop, int part) {
        Apfloat piece = new Apfloat (0.0, 100);
        for (long i = start; i < stop; i++) {
            piece = piece.add (calculateTerm (i));
        }
        parts [part] = piece;
    }

    public static void main(String[] args) throws InterruptedException {
        Apfloat pi = new Apfloat (3.0, 100);
        Thread [] workers = new Thread [NUM_THREADS];
        for (int count = 0; count < NUM_THREADS; count++) {
            int start = count;
            workers [count] = new Thread (()->
                calculatePiPortion (start * CHUNK_SIZE + 1, (start + 1) * CHUNK_SIZE + 1, start));
        }

        for (int count = 0; count < NUM_THREADS; count++) {
            workers [count].start ();
        }

        for (int count = 0; count < NUM_THREADS; count++) {
            workers [count].join ();
        }

        for (int index = 0; index < NUM_THREADS; index++) {
            pi = pi.add (parts [index]);
        }

        System.out.println (pi.toString (true));
    }
}

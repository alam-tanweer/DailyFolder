package unit11.assignment2.pi;

import org.apfloat.Apfloat;

public class MTChunkCalculator extends PiCalculator {
    private Apfloat pi;

    public MTChunkCalculator (PiTermCalculator termCalc) {
        super (termCalc);
    }

    private void calculateRange (long start, long stop) {
        Apfloat myPiece = new Apfloat (0.0, termCalc.getPrecision());
        for (long i = start; i < stop; i++) {
            myPiece = myPiece.add (termCalc.calculateTerm (i));
        }
        synchronized (this) {
            pi = pi.add (myPiece);
        }
    }

    public Apfloat calculate(long numTerms) { 
        Thread [] threads = new Thread [20];
        long chunkSize = numTerms / threads.length;
        pi = new Apfloat (0.0, termCalc.getPrecision());

        for (int i = 0; i < threads.length; i++) {
            long num = i;
            threads [i] = new Thread (()-> 
                calculateRange (num * chunkSize, (num + 1) * chunkSize));
            threads [i].start ();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads [i].join();
            } catch (InterruptedException ie) {}
        }
        return termCalc.finalAdjustment (pi);        
    }
    
}

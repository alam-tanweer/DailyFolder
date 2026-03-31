package unit11.assignment2.pi;

import org.apfloat.Apfloat;

public class MTCalculator extends PiCalculator {
    private Apfloat pi;

    public MTCalculator (PiTermCalculator termCalc) {
        super (termCalc);
    }

    /** Very Poor Implementation **/
    @Override
    public Apfloat calculate(long numTerms) {
        Thread [] threads = new Thread [(int)numTerms];
        pi = new Apfloat (0.0, termCalc.getPrecision());
        for (int i = 0; i < numTerms; i++) {
            long num = i;
            threads [i] = new Thread (()-> {
                Apfloat term = termCalc.calculateTerm (num);
                synchronized (this) {
                    // System.out.println (termCalc.calculateTerm (num).toString(true));
                    pi = pi.add (term);
                    // System.out.println (pi.toString(true));
                }
            });
            threads [i].start ();
        }
        for (int i = 0; i < numTerms; i++) {
            try {
                threads [i].join();
            } catch (InterruptedException ie) {}
        }
        synchronized (pi) {
            return termCalc.finalAdjustment (pi);
        }
    }
}

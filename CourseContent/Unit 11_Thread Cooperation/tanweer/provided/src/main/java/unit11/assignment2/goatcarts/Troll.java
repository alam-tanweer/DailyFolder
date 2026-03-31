package unit11.assignment2.goatcarts;

import java.util.Arrays;

public class Troll implements TrollInterface {

    private final GoatCart[] racers;
    private final int numRacers;
    private int numRegistered;
    private boolean raceFinished;
    private String dialog;
    private static final int NUM_LAPS = 5;

    public Troll (int numRacers) {
        this.numRacers = numRacers;
        numRegistered = 0;
        racers = new GoatCart[this.numRacers];
        raceFinished = false;
        dialog = "Welcome to the GoatCart 5000";
    }

    public int getNumRacers() {
        return numRacers;
    }

    public boolean getRaceFinished (){
        return raceFinished;
    }

    @Override
    public int getNumLaps() {
        return NUM_LAPS;
    }

    public synchronized void registerCart (GoatCart cart) {
        if (numRegistered < numRacers) {
            racers [numRegistered] = cart;
            numRegistered++;
        }
    }

    @Override
    public String getDialog() {
        return dialog;
    }

    public GoatCart[] getPositions () {
        GoatCart[] pos = null;
        synchronized (this) {
            pos = Arrays.copyOf(racers, racers.length);
        }
        
        if (numRacers == numRegistered) {
            Arrays.sort (pos, (a, b)-> (int)((a.getRaceTime() - b.getRaceTime())*1000)); 
        }
        return pos;
    }

    public void runRace() {
        dialog = "Racers are lining up!";

        Thread[] threads = new Thread[numRacers];
        for (int i = 0; i < numRacers; i++) {
            int number = i + 1;
            GoatCart cart = new GoatCart (number, this);
            System.out.println (cart);
            threads [number - 1] = new Thread (cart);
            threads[number - 1].start ();
        }
        while (numRegistered != numRacers) {
            try {
                Thread.sleep (250);
            } catch (InterruptedException ie) {}
        }

        synchronized (this) {
            this.notifyAll();
        }

        dialog = "The race has started!";
        System.out.println (dialog);
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join ();
            } catch (InterruptedException ie){}
        }
        raceFinished = true;
        dialog = "The race has finished!";
        System.out.println (dialog);
    }
    
}

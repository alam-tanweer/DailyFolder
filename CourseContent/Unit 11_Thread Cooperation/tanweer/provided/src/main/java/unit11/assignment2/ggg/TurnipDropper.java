package unit11.assignment2.ggg;

import java.util.Random;

public class TurnipDropper implements Runnable {
    private static final Random RNG = new Random();
    private static int MIN_SLEEP = 0; // 100;
    private static int MAX_SLEEP = 1; // 250;
    private static int MAX_TURNIPS = 3;

    private final Trough trough;

    public TurnipDropper(Trough trough) {
        this.trough = trough;
    }

    @Override
    public void run() {
        System.out.println("The turnip dropper starts dropping turnips!");
        while(keepDropping()) {
            randomSleep();
            dropTurnips();
        }
        System.out.println("The turnip dropper has run out of turnips!");
    }

    private boolean keepDropping() {
        synchronized(trough) {
            return !trough.atLimit();
        }
    }

    private void dropTurnips() {
        int turnipsToDrop = RNG.nextInt(MAX_TURNIPS) + 1;
        System.out.println("The dropper drops " + turnipsToDrop 
            + " turnips into the trough!");
        for(int turnip=0; turnip<turnipsToDrop; turnip++) {
            synchronized(trough) {
                trough.drop();
                trough.notifyAll();
            }
        }
    }

    private void randomSleep() {
        try {
            int duration = RNG.nextInt(MIN_SLEEP, MAX_SLEEP + 1);
            Thread.sleep(duration);
        } catch(InterruptedException exception) {
            // squash
        }
    }
}

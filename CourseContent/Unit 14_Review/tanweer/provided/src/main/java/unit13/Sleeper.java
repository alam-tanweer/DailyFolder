package unit13;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sleeper implements Runnable {

    private final int seconds;

    public Sleeper(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public void run() {
        try {
            System.out.println("Sleeping for " + seconds + " seconds...");
            Thread.sleep(seconds * 1000);
            System.out.println("I'm awake!");
        } catch (InterruptedException e) {
            // squash
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // v1
        // Sleeper sleeper = new Sleeper(5);
        // Thread thread = new Thread(sleeper);
        // thread.start();

        // v2
        Random RNG = new Random(1);
        List<Thread> threads = new ArrayList<>(5);
        for(int i=0; i<5; i++) {
            int time = RNG.nextInt(10) + 1;
            Sleeper sleeper = new Sleeper(time);
            Thread thread = new Thread(sleeper);
            thread.start();
            threads.add(thread);
        }

        for(Thread thread : threads) {
            thread.join();
        }
        System.out.println("Everyone's awake!");
    }
    
}

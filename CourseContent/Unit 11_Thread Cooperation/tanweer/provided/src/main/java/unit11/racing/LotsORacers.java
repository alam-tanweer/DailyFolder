package unit11.racing;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Students will modify their main but both the initial and final varients are recoreded as 
 * methods in the solution below.
 */
public class LotsORacers {

    private static final int NUM_RACERS = 1000;
    private static final int NUM_LAPS = 10;
    private static final boolean DEBUG = false;

    public static void latchRace () {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(NUM_RACERS);
        List<Racer> finishers = new LinkedList<>();

        Lock finishLock = new ReentrantLock();

        for (int i = 0; i < NUM_RACERS; i++) {
            String name = "Racer " + (i + 1);
            Racer racer = new Racer(name, NUM_LAPS, DEBUG);
            executor.submit(() -> {
                try {
                    start.await(); // Wait for the start latch to be released
                    racer.race();
                    try {
                        finishLock.lock();
                        finishers.add(racer);
                    } finally {finishLock.unlock();}
                    done.countDown(); // Signal that this racer is done
                } catch (InterruptedException e) {
                    System.out.println(racer.getName() + " was interrupted.");
                }
            });
        }
        System.out.println("All racers have been submitted.");

        executor.shutdown();
        start.countDown(); // Start the race

        try {
            done.await(); // Wait for all racers to finish
        } catch (InterruptedException e) {}

        System.out.println("All racers have finished.");
        // Standard output
        finishers.stream().forEach(r -> System.out.println(r.getName() + " finished in " + r.getFinishTime() + " seconds."));
        // Challenge output (can also be done in a loop the old fashioned way)
        finishers.stream().max((r1, r2) -> Double.compare(r1.getFinishTime(), r2.getFinishTime()))
            .ifPresent(winner -> System.out.println(winner.getName() + " wins with a time of " + winner.getFinishTime() + " seconds!"));
        System.out.println(finishers.size() + " racers finished.");
    }


    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        startTime = System.nanoTime();
        latchRace();
        endTime = System.nanoTime();
        System.out.println("Race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds");  
    }    
}


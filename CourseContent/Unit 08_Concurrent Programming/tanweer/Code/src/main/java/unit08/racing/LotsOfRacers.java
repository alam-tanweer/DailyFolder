package unit08.racing;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LotsOfRacers {

    private static final int NUM_RACERS = 1000;
    private static final int NUM_LAPS = 5;
    private static final boolean DEBUG = false;
    private static Object lock = new Object();

    public static void threadRace () {
        Thread[] racers = new Thread[NUM_RACERS];

        for (int i = 0; i < NUM_RACERS; i++) {
            String name = "Racer " + (i + 1);
            Racer racer = new Racer(name, NUM_LAPS, DEBUG);
            racers[i] = new Thread(racer::race);
            racers[i].start();
        }
        System.out.println("All racers have been started.");

        // System.out.println("All racers have been created.");

        // for(Thread t : racers){
        //     t.start();
        // }

        // System.out.println("All racers have been started.");        
    }

    public static void executorRace ()  {

        // int cores = Runtime.getRuntime().availableProcessors();
        // ExecutorService exservice = Executors.newFixedThreadPool(cores);

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < NUM_RACERS; i++) {
            String name = "Racer " + (i + 1);
            Racer racer = new Racer(name, NUM_LAPS, DEBUG);
            executor.submit(racer::race);
        }

        //shutdown need to be called first. otherwise await will keep waiting

        executor.shutdown();
        boolean finished = false;
        try {
            finished = executor.awaitTermination(150, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        if (!finished) {
            System.out.println("Timed out waiting for racers to finish!");
        } else {
            System.out.println("All racers finished.");
        }        

        System.out.println("All racers have been submitted. finished: " + finished);
    }

    public static void latchRacePre() {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);

        for (int i = 0; i < NUM_RACERS; i++) {
            String name = "Racer " + (i + 1);
            Racer racer = new Racer(name, NUM_LAPS, DEBUG);
            executor.submit(() -> {
                try {
                    start.await(); // Wait for the start latch to be released
                    racer.race();
                } catch (InterruptedException e) {
                    System.out.println(racer.getName() + " was interrupted.");
                }
            });
        }
        System.out.println("All racers have been submitted.");

        executor.shutdown(); // Don't Accept any new request.
        start.countDown(); // Start the race

        boolean finished = false;
        try {
            finished = executor.awaitTermination(150, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
                
        System.out.println("All racers have finished.");
    }

    public static void latchRace () {
        ExecutorService executor = Executors.newCachedThreadPool();
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(NUM_RACERS);
        List<Racer> finishers = new LinkedList<>();
        // List<Racer> finishers = Collections.synchronizedList(new LinkedList<>());

        for (int i = 0; i < NUM_RACERS; i++) {
            String name = "Racer " + (i + 1);
            Racer racer = new Racer(name, NUM_LAPS, DEBUG);
            executor.submit(() -> {
                try {
                    start.await(); // Wait for the start latch to be released
                    racer.race();
                    // synchronized(lock){
                    //     finishers.add(racer);
                    // }
                    // finishers.add(racer);
                    done.countDown(); // Signal that this racer is done
                } catch (InterruptedException e) {
                    System.out.println(racer.getName() + " was interrupted.");
                }
            });
        }
        System.out.println("All racers have been submitted.");

        executor.shutdown(); // Don't Accept any new request.
        start.countDown(); // Start the race

        try {
            done.await(); // Wait for all racers to finish
        } catch (InterruptedException e) {}

        System.out.println("All racers have finished. Total number of finisher: " + finishers.size());
        // Standard output
        finishers.forEach(r -> System.out.println(r.getName() + " finished in " + r.getFinishTime() + " seconds."));
        // Challenge output (can also be done in a loop the old fashioned way)
        finishers.stream().max((r1, r2) -> Double.compare(r1.getFinishTime(), r2.getFinishTime()))
            .ifPresent(winner -> System.out.println(winner.getName() + " wins with a time of " + winner.getFinishTime() + " seconds!"));
        System.out.println(finishers.size() + " racers finished.");
    }



    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        // startTime = System.nanoTime();
        // threadRace();
        // endTime = System.nanoTime();
        // System.out.println("Thread race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds"); 

        // int cores = Runtime.getRuntime().availableProcessors();
        // System.out.print("Cores : " + cores);

        // startTime = System.nanoTime();
        // executorRace();
        // endTime = System.nanoTime();
        // System.out.println("Executor race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds");  

        // startTime = System.nanoTime();
        // latchRacePre();
        // endTime = System.nanoTime();
        // System.out.println("Latch race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds");  

        startTime = System.nanoTime();
        latchRace();
        endTime = System.nanoTime();
        System.out.println("Latch race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds");  
    }       
}

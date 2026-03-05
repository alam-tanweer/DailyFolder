package unit08.racing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LotsOfRacers {

    private static final int NUM_RACERS = 100;
    private static final int NUM_LAPS = 10;
    private static final boolean DEBUG = false;

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

    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;

        // startTime = System.nanoTime();
        // threadRace();
        // endTime = System.nanoTime();
        // System.out.println("Thread race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds"); 

        // int cores = Runtime.getRuntime().availableProcessors();
        // System.out.print("Cores : " + cores);

        startTime = System.nanoTime();
        executorRace();
        endTime = System.nanoTime();
        System.out.println("Executor race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds");  

        // startTime = System.nanoTime();
        // latchRace();
        // endTime = System.nanoTime();
        // System.out.println("Latch race completed in " + (endTime - startTime) / 1_000_000_000.0 + " seconds");  
    }       
}

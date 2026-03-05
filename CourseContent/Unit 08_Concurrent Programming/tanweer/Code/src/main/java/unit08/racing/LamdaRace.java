package unit08.racing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LamdaRace {

    public static void main(String[] args) {
        Racer r1 = new Racer("Mario", 10, true);
        Racer r2 = new Racer("Peach", 10, true);
        Racer r3 = new Racer("Luigi", 10, true);

        Thread racer1 = new Thread(() -> r1.race());
        Thread racer2 = new Thread(new Runnable() {
            @Override
            public void run(){
                r2.race();
            }
        });
        // Thread racer1 = new Thread(r1::race);
        // Thread racer2 = new Thread(r2::race);
        Thread racer3 = new Thread(r3::race);

        racer1.start();
        racer2.start();
        racer3.start();

        while (racer1.isAlive() || racer2.isAlive() || racer3.isAlive()) {
            // Wait for all racers to finish
        }

        System.out.println(r1.getName() + " Finished in " + r1.getFinishTime() + " seconds");
        System.out.println(r2.getName() + " Finished in " + r2.getFinishTime() + " seconds");
        System.out.println(r3.getName() + " Finished in " + r3.getFinishTime() + " seconds");

        
        //8.11
        // Use an ExecutorService instead of creating Thread objects ourselves
        // ExecutorService exservice = Executors.newCachedThreadPool();
        // Or fixed pool:
        // int cores = Runtime.getRuntime().availableProcessors();
        // ExecutorService exservice = Executors.newFixedThreadPool(cores);

        // Submit tasks (lambdas)
        // exservice.submit(r1::race);
        // exservice.submit(r2::race);
        // exservice.submit(r3::race);

        // // IMPORTANT: stop accepting new tasks
        // exservice.shutdown();

        // // Wait for executor to finish (timeout required)
        // boolean finished = false;
        // try {
        //     finished = exservice.awaitTermination(5, TimeUnit.SECONDS);
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // if (!finished) {
        //     System.out.println("Timed out waiting for racers to finish!");
        // } else {
        //     System.out.println("All racers finished.");
        // }

        // System.out.println(r1.getName() + " Finished in " + r1.getFinishTime() + " seconds");
        // System.out.println(r2.getName() + " Finished in " + r2.getFinishTime() + " seconds");
        // System.out.println(r3.getName() + " Finished in " + r3.getFinishTime() + " seconds");        
    }
}

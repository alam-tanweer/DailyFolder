package mte.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerTask implements Runnable {
    private int taskID;

    public WorkerTask(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public void run() {

        System.out.println("Task " + taskID + " started");
        Random rand = new Random();
        int random = rand.nextInt(1, 21);
        try {
            Thread.sleep(random);
            System.out.println("Task " + taskID + " completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        ExecutorService ex = Executors.newCachedThreadPool();

        for (int i = 0; i <= 4; i++) {
            Runnable runnable = new WorkerTask(i);
            Thread thread = new Thread(runnable);

            ex.submit(thread);
        }
        latch.countDown();

        try {
            ex.awaitTermination(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }

        ex.shutdown();
        
        System.out.println("All tasks completed.");

    }
}

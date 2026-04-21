package mte.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

public class WorkerTask extends Thread {
    private int task_id;
    private CountDownLatch latch;


    public WorkerTask(int task_id, CountDownLatch latch) {
        this.task_id = task_id;
        this.latch = latch;
    }

    public void run() {
        try {
        latch.await();
        System.out.println("Task " + task_id + " started");
        RandomGenerator rng = new Random();
        int work = rng.nextInt(1000, 20001);
        Thread.sleep(work);
        }
        catch (Exception e) { }
        System.out.println("Task " + task_id + " completed.");
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);

        WorkerTask task1 = new WorkerTask(1, latch);
        WorkerTask task2 = new WorkerTask(2, latch);
        WorkerTask task3 = new WorkerTask(3, latch);
        WorkerTask task4 = new WorkerTask(4, latch);
        WorkerTask task5 = new WorkerTask(5, latch);

        ExecutorService exserv = Executors.newCachedThreadPool();

        exserv.submit(task1);
        exserv.submit(task2);
        exserv.submit(task3);
        exserv.submit(task4);
        exserv.submit(task5);

        latch.countDown();
        exserv.shutdown();
        try {
            exserv.awaitTermination(25, TimeUnit.SECONDS);
        }
        catch (Exception e) { }
        System.out.println("All tasks completed.");

    }    
}

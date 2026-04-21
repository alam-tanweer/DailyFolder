package mte.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerTask implements Runnable{

    private static CountDownLatch start = new CountDownLatch(1);
    private static CountDownLatch finish = new CountDownLatch(5);
    private int ID;

    public WorkerTask(int ID){
        this.ID = ID;
    }

    @Override
    public void run(){
        Random random = new Random();
        try {
            start.await(100,TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task " + ID + " started");

        try {
            int time = random.nextInt(1,21);
            Thread.sleep(1000 * time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + ID + " completed.");
        finish.countDown();
    }

    public static void main(String[] args) {
        ExecutorService exc = Executors.newCachedThreadPool();

        for(int i = 0; i < 5; i++){
            exc.submit(new WorkerTask(i));
        }
        start.countDown();

        try {
            finish.await(100,TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.");
    }    
}

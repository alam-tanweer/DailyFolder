package mte.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerTask implements Runnable{
    private int taskID;
    public static CountDownLatch start = new CountDownLatch(1);
    public static CountDownLatch finish = new CountDownLatch(5);

    

    public WorkerTask(int tasks) {
        this.taskID = tasks;
    }



    @Override
    public void run() {
        try {
            Random rand = new Random();
            start.await();
            System.out.println("Task "+this.taskID+" has started");
            Thread.sleep(rand.nextInt(0,1000));
            finish.countDown();
            System.out.println("Task "+this.taskID+" has finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    


    public static void main(String[] args){
        ExecutorService exServe = Executors.newCachedThreadPool();
        for(int i =1; i<=5;i++){
            try {
                exServe.submit(new WorkerTask(i));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        start.countDown();
        try {
            finish.await();
            exServe.shutdown();
            exServe.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\nAll tasks completed");
    }    
}

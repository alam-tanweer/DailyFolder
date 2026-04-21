package mte.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerTask implements Runnable{
    private int id;
    public static CountDownLatch latch = new CountDownLatch(5);
    public Random rand = new Random();

    public WorkerTask(int id){
        this.id = id;
    }
    @Override
    public void run(){
        try{
            System.out.println("Task " + id + " started");
            Thread.sleep(rand.nextInt(1000,20000));
            latch.countDown();
            latch.await();
            System.out.println("Task " + id + " completed");
        } catch(InterruptedException ex){
            ex.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i<=5;i++){
            exec.submit(new WorkerTask(i));
        }
        try{
            while (!exec.awaitTermination(21, TimeUnit.SECONDS)){
                System.out.println("All tasks completed.");
            }
        } catch(InterruptedException ex){
            ex.printStackTrace();
        }
        exec.shutdown();
    }    
}

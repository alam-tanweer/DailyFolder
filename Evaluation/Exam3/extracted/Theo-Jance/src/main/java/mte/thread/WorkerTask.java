package mte.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.crypto.spec.RC2ParameterSpec;

public class WorkerTask implements Runnable{
    private int id;
    private CountDownLatch latch;
    private Random rand = new Random();

    public WorkerTask(int id, CountDownLatch latch){
        this.id = id;
        this.latch = latch;
    }
    @Override
    public void run(){
        try {
            latch.await();
            System.out.println("Task " + id + " started");
            int sleepTime = rand.nextInt(1000,20000);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " completed");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(5);

        try{
        for(int i = 1; i <= 5; i ++){
            exec.submit(new WorkerTask(i, latch));
            latch.countDown();
        }
        exec.shutdown();

        exec.awaitTermination(1, TimeUnit.DAYS);

        }catch(Exception ex){
            ex.printStackTrace();
        }

        System.out.println("All tasks completed");
    }    
}

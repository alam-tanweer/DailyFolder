package mte.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class WorkerTask implements Runnable{
    private int id;
    private static CountDownLatch cdl = new CountDownLatch(1);
    public WorkerTask(int id){
        this.id=id;
    }
    
    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " started");
        try {
            Thread.sleep(new Random().nextInt(100, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + id + " completed");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 1; i <= 3; i++){
            es.submit(new WorkerTask(i));
        }
        cdl.countDown();
        es.shutdown();
        es.awaitTermination(1000, TimeUnit.SECONDS);
        System.out.println("All tasks completed.");
    }    
}

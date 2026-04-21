package mte.thread;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerTask extends Thread {
    @Override
    public void run() {
        try{
        Thread.sleep(100);}
        catch (InterruptedException E) {E.printStackTrace();}
    }

    public static void main(String[] args) throws InterruptedException{
        ExecutorService execServ = Executors.newCachedThreadPool();
        int n = 5;
        CountDownLatch gate = new CountDownLatch(n);
        int num = 0; 
        while(num < n) {
            execServ.submit(new WorkerTask(), "Task number" + num);
            System.out.println("Task Id Started Task number" + num);
            // execServ.submit(thread);
            gate.await();
            num++;
            gate.countDown();
        }
        
        
        execServ.shutdown();
        execServ.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println("All Tasks Completed");
    }
}

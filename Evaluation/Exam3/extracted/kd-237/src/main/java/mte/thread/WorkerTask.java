package mte.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerTask {

    // int task_number;

    // public WorkerTask(int task_number){
    //     this.task_number = task_number;
    // }


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch gate = new CountDownLatch(1);
        
        ExecutorService ex = Executors.newCachedThreadPool();
        

        for(int i = 0; i <= 5; i++){
            int id = i;
            ex.submit(() -> {
                System.out.println("Task " + id +" started");
                try {
                        Thread.sleep(20);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
               
                try {
                    gate.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    
                } System.out.println("Task " + id +" completed");

            } );

        }
        gate.countDown();

            ex.shutdown();
            
            ex.awaitTermination(30, TimeUnit.SECONDS);
            System.out.println("ALL Task completed");


        
    }    
}

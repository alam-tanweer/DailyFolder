package mte.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkerTask implements Runnable {
    //WORker task unique ID
    private int id;
    public WorkerTask(int id){
        this.id = id;
    }
 

    @Override
    public void run() {
        //Print the task ID and sleep for a random time between 1 and 20 seconds
        Random RNG = new Random();
        try {
            for(int i =0;i<i;i++){

            System.out.println("Task " + id + " started" );
        }
            Thread.sleep(RNG.nextLong(1000,20000)+1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        }
    

    public static void main(String[] args) {
        ExecutorService ex = Executors.newCachedThreadPool();

        
        Thread[] threads = new Thread[5];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(new WorkerTask(i));
            ex.submit(threads[i]::run);
        }
        
        


        ex.shutdown();
    }

    
}

package unit11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HelloThreadV1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello, world!");
    }

    // public static void main(String[] args) {
    //     List<Thread> threads = new ArrayList<>();
        
    //     for(int i=0; i<5; i++) {
    //         HelloThreadV1 hello = new HelloThreadV1();
    //         Thread thread = new Thread(hello);
    //         threads.add(thread);
    //         thread.start();
    //     }

    //     // for(Thread t : threads){
    //     //     try {
    //     //         // while(t.isAlive()){}
    //     //         // t.join();
    //     //     } catch (Exception e) {
    //     //         // TODO Auto-generated catch block
    //     //         e.printStackTrace();
    //     //     }
    //     // }

    //     System.out.println("Completed the program....");
    // }

    public static void main(String[] args) {
        ExecutorService exService = Executors.newCachedThreadPool();
        for(int i=0; i<5; i++){
            // exService.submit(new HelloThreadV1());
            exService.submit(() -> System.out.println("HelloWorld"));
        }

        exService.shutdown();
        try {
            exService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Completed the program....");
    }    
    
}
package unit11;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HelloThreadv3 implements Runnable {

    private static CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void run() {
        System.out.println("waiting on latch.");
        try {
            latch.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Hello, world!");
    }

    public static void main(String[] args) {
        ExecutorService exService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            //We can put the latch here also
            exService.submit(new HelloThreadv3());
        }

        exService.shutdown();

        try {
            Thread.sleep(100);
            System.out.print("Opening the latch...");
            latch.countDown();            
            exService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Completed the program....");
    }
}

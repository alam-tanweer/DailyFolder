package unit11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TheCountv1 implements Runnable {
    private static int COUNT = 0;
    private final String id;

    public TheCountv1(String id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Counter " + id + " is starting...");
        for(int i=0; i<100000; i++) {
            COUNT++;
        }
        System.out.println("Counter " + id + " is done!");
        // code example for slides
        // int temp = COUNT[0] + 1;
        // COUNT[0] = temp;
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        TheCountv1 theCount = new TheCountv1("1");
        exec.execute(theCount);
        exec.shutdown();

        exec.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(String.format("%,d", COUNT));
    }
    
}

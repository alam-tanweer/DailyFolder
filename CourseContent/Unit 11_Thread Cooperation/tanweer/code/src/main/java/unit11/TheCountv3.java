package unit11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The correct solution.
 */
public class TheCountv3 implements Runnable {
    private static int COUNT = 0;
    private static final Lock countLock = new ReentrantLock();

    private final String id;

    public TheCountv3(String id) {
        this.id = id;
    }

    public void run() {
        
        System.out.println(id + " is starting...");
        for(int i=0; i<100000; i++) {
            try {
                countLock.lock();
                COUNT++;
            } finally {
                countLock.unlock();
            }
        }
        System.out.println(id + " is done!");
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            TheCountv3 theCount = new TheCountv3("Count" + i);
            exec.execute(theCount::run);
        }
        exec.shutdown();

        exec.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(String.format("%,d", COUNT));
    }  
}

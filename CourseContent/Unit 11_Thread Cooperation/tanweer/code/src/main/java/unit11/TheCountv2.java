package unit11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This class exists to make a point about being surgical when choosing which
 * lines of code to synchronize.
 */
public class TheCountv2 extends Thread {
    private static int COUNT = 0;
    private static final Lock countLock = new ReentrantLock();

    private final String id;

    public TheCountv2(String id) {
        this.id = id;
    }

    public void run() {
        try {
            // 11.4
            countLock.lock();
            System.out.println("Counter " + id + " is starting...");
            for(int i=0; i<100000; i++) {
                COUNT++;
            }
            System.out.println("Counter " + id + " is done!");
        } finally {
            // 11.4
            countLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            TheCountv2 theCount = new TheCountv2("Count" + i);
            // exec.execute(theCount::run);
            exec.submit(theCount);
        }
        exec.shutdown();

        exec.awaitTermination(1, TimeUnit.DAYS);
        System.out.println(String.format("%,d", COUNT));
    }
}

package unit11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiterv4 implements Runnable {
    private final Lock lock;
    private final Condition alarm;

    public Waiterv4(Lock lock, Condition alarm) {
        this.lock = lock;
        this.alarm = alarm;
    }

    public void run() {
        try {
            lock.lock();
            alarm.awaitUninterruptibly();
        }finally {
            lock.unlock();
        }
        System.out.println("Done waiting!");
    }

    public static void main(String[] args) throws InterruptedException {
        // v1: just hangs
        Lock lock = new ReentrantLock();
        Condition alarm = lock.newCondition();
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            service.execute(new Waiterv4(lock, alarm)::run);
        }
        service.shutdown();
        
        // this is not the best solution, but is necessary for the next
        // activity.
        Thread.sleep(100);

        try {
            lock.lock();
            alarm.signalAll();
            System.out.println("Thread notified!");
        } finally { lock.unlock(); }
    }
}

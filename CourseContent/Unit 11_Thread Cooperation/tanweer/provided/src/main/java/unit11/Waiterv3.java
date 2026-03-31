package unit11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiterv3 implements Runnable {
    private final Lock lock;
    private final Condition alarm;

    public Waiterv3(Lock lock, Condition alarm) {
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

        Waiterv1 waiter = new Waiterv1(lock, alarm);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(waiter::run);
        service.shutdown();
        
        // this is not the best solution, but is necessary for the next
        // activity.
        Thread.sleep(100);

        try {
            lock.lock();
            alarm.signal();
            System.out.println("Thread notified!");
        } finally { lock.unlock(); }
    }
}

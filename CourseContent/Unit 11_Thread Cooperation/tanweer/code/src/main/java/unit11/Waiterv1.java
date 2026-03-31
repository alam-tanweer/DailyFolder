package unit11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiterv1 { //implements Runnable{
    private final Lock lock;
    private final Condition alarm;

    public Waiterv1(Lock lock, Condition alarm) {
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
        service.execute(() -> waiter.run());
        // service.submit(waiter);
        // service.submit(() -> waiter.run());

        System.out.println("Thread started!");
    }
}
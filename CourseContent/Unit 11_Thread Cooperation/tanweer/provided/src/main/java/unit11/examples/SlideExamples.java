package unit11.examples;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SlideExamples {

    private Lock lock;
    private Condition condition;

    public void consume() {
        try {
            lock.lock();
            condition.awaitUninterruptibly();
        } finally {
            lock.unlock();
        }
    }
    
    public void produce(String message) {
        try {
            lock.lock();
            condition.signal();
            System.out.println("Notified!");
        } finally {
            lock.unlock();
        }
    }
}

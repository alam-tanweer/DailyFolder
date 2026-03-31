package unit11;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumerv2 {
    private final LinkedList<String> queue;
    private final Lock lock;
    private final Condition condition;
    private final int id;

    public Consumerv2(int id, LinkedList<String> queue, Lock lock, Condition condition) {
        this.id = id;
        this.queue = queue;
        this.lock = lock;
        this.condition = condition;
    }

    public void consume() {
        while(true) {
            String message = null;
            lock.lock();
            try {
                while(queue.isEmpty()) {
                    condition.awaitUninterruptibly();
                }
                message = queue.remove(0);
            } finally {
                lock.unlock();  
            }
            System.out.println("Consumer " + id + ": " + message);
        }
    }
}

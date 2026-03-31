package unit11;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumerv1 {
    private final LinkedList<String> queue;
    private final Lock lock;
    private final Condition condition;
    private final int id;

    public Consumerv1(int id, LinkedList<String> queue, Lock lock, Condition condition) {
        this.id = id;
        this.queue = queue;
        this.lock = lock;
        this.condition = condition;
    }

    public void consume() {
        // this is purposely incorrect for multiple consumers because one
        // consumer will always handle all of the jobs. we will fix it in 
        // later activities.
        lock.lock();
        try {
            while(true) {
                while(!queue.isEmpty()) {
                    String message = queue.remove(0);
                    System.out.println(id + ": " + message);
                }
                System.out.println(id + " waiting for work...");
                condition.awaitUninterruptibly();
            }
        } finally {
            lock.unlock();
        }        
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        queue.add("First Message");
        queue.add("Second Message");

        Consumerv1 consumer = new Consumerv1(0, queue, lock, condition);
        Thread thread = new Thread(consumer::consume);
        thread.start();
    }
}

package unit11;

import java.util.LinkedList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Consumerv1 implements Runnable {
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

    // @Override
    // public void run() {
    //     // this is purposely incorrect for multiple consumers because one
    //     // consumer will always handle all of the jobs. we will fix it in 
    //     // later activities.
    //     lock.lock();
    //     try {
    //         while(true) {
    //             while(!queue.isEmpty()) {
    //                 String message = queue.remove(0);
    //                 System.out.println("Consumer : " + id + ": " + message);
    //             }
    //             System.out.println(id + " waiting for work...");
    //             condition.awaitUninterruptibly();
    //         }
    //     } finally {
    //         lock.unlock();
    //     }        
    // }

    //11.14 - Fix for above commented issue
    @Override
    public void run() {
        while(true) {
            String message = null;
            lock.lock();
            try {
                while(queue.isEmpty()) {
                    System.out.println(id + " waiting for work...");
                    condition.awaitUninterruptibly();
                }
                message = queue.remove(0);
            } finally {
                lock.unlock();  
            }
            System.out.println("Consumer " + id + ": " + message);
        }
    }    

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        queue.add("First Message");
        queue.add("Second Message");

        Consumerv1 consumer = new Consumerv1(0, queue, lock, condition);
        ExecutorService exService = Executors.newCachedThreadPool();
        exService.submit(consumer);
        exService.shutdown();
    }
}

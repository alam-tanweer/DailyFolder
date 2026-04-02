package unit11;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {
    private static final Random RNG = new Random(1);

    private final int id;
    private final LinkedList<String> queue;
    private final Lock lock;
    private final Condition condition;

    public Producer(int id, LinkedList<String> queue, Lock lock, Condition condition) {
        this.id = id;
        this.queue = queue;
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        int messageNumber = 1;
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // squash
            }
            int numberOfMessages = RNG.nextInt(4) + 1;
            lock.lock();
            try {
                for(int n=0; n<numberOfMessages; n++) {
                    String message = "Producer " + id + ": message #" 
                        + messageNumber;
                        queue.add(message);
                    messageNumber++;
                }
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ExecutorService executor = Executors.newCachedThreadPool();

        //11.13
        // Consumerv1 consumer = new Consumerv1(0, queue, lock, condition);
        // Producer producer = new Producer(0, queue, lock, condition);
        // executor.submit(producer);
        // executor.submit(consumer);

        for(int i=0; i<5; i++) {
            Consumerv1 consumer = new Consumerv1(i, queue, lock, condition);
            executor.submit(consumer);
        }

        for(int i=0; i<2; i++) {
            Producer producer = new Producer(i, queue, lock, condition);
            executor.submit(producer);
        }

        executor.shutdown();
    }
}

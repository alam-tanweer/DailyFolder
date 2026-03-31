package unit11.legacy;

import java.util.LinkedList;

public class Consumerv2 implements Runnable {
    private final LinkedList<String> queue;
    private final int id;

    public Consumerv2(int id, LinkedList<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            String message = null;
            synchronized(queue) {
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        // squash
                    }
                }
                message = queue.remove(0);
            }
            System.out.println("Consumer " + id + ": " + message);
        }
    }
}

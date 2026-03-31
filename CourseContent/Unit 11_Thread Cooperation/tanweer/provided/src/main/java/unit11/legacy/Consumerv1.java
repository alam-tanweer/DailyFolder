package unit11.legacy;

import java.util.LinkedList;

public class Consumerv1 implements Runnable {
    private final LinkedList<String> queue;
    private final int id;

    public Consumerv1(int id, LinkedList<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        // this is purposely incorrect for multiple consumers because one
        // consumer will always handle all of the jobs. we will fix it in 
        // later activities.
        synchronized(queue) {
            while(true) {
                while(!queue.isEmpty()) {
                    String message = queue.remove(0);
                    System.out.println(id + ": " + message);
                }
                try {
                    System.out.println(id + " waiting for work...");
                    queue.wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }
        }        
    }

    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("First Message");
        queue.add("Second Message");

        Consumerv1 consumer = new Consumerv1(0, queue);
        Thread thread = new Thread(consumer);
        thread.start();
    }
}

package unit11.legacy;

public class Waiterv2 implements Runnable {
    private final Object lock;

    public Waiterv2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            try {
                lock.notify();
                lock.wait();
            } catch (InterruptedException e) {
                // squash
            }
            System.out.println("Done waiting!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // v2: race condition
        Object lock = new Object();
        Waiterv2 waiter = new Waiterv2(lock);
        Thread thread = new Thread(waiter);
        thread.start();
        synchronized(lock) {
            lock.notify();
        }
        System.out.println("Thread notified!");
    }
    
}

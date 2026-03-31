package unit11.legacy;

public class Waiterv1 implements Runnable {
    private final Object lock;

    public Waiterv1(Object lock) {
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
        // v1: just hangs
        Object lock = new Object();
        Waiterv1 waiter = new Waiterv1(lock);
        Thread thread = new Thread(waiter);
        thread.start();
        System.out.println("Thread started!");
    }
}

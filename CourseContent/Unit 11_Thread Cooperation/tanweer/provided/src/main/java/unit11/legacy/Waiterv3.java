package unit11.legacy;

public class Waiterv3 implements Runnable {
    private final Object lock;

    public Waiterv3(Object lock) {
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
        // v3: works for one thread
        Object lock = new Object();
        Waiterv3 waiter = new Waiterv3(lock);
        Thread thread = new Thread(waiter);
        thread.start();
        // this is not the best solution, but is necessary for the next
        // activity.
        Thread.sleep(1000);
        synchronized(lock) {
            lock.notify();
            System.out.println("Thread notified!");
        }
    }
}

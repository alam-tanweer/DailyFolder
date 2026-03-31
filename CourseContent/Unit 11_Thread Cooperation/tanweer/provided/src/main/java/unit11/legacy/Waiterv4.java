package unit11.legacy;

public class Waiterv4 implements Runnable {
    private final Object lock;

    public Waiterv4(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized(lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                // squash
            }
            System.out.println("Done waiting!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // v4: notify all
        Object lock = new Object();
        for(int i=0; i<10; i++) {
            Waiterv4 waiter = new Waiterv4(lock);
            Thread thread = new Thread(waiter);
            thread.start();
        }
        
        Thread.sleep(1000);
        synchronized(lock) {
            lock.notifyAll();
            System.out.println("Thread notified!");
        }
    }
}

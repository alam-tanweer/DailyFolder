package unit10.practicum;

public class EvensAndOdds implements Runnable {
    private final Object lock;
    private final int start;

    public EvensAndOdds(Object lock, int start) {
        this.lock = lock;
        this.start = start;
    }

    @Override
    public void run() {
        synchronized(lock) {
            lock.notify();
            for(int i=start; i<=100; i+=2) {
                System.out.println(i);
                lock.notify();
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }
            lock.notify();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        synchronized(lock) {
            EvensAndOdds odds = new EvensAndOdds(lock, 1);
            new Thread(odds).start();
            lock.wait();

            EvensAndOdds evens = new EvensAndOdds(lock, 2);
            new Thread(evens).start();
        }
    }
    
}
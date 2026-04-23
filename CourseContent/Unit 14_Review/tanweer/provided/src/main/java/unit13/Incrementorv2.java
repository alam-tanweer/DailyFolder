package unit13;

import java.util.ArrayList;
import java.util.List;

public class Incrementorv2 {
    private int count;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        int numberOfIncrements = 100000;

        Incrementorv2 counter = new Incrementorv2();

        List<Thread> threads = new ArrayList<>();
        for(int i=0; i<10; i++) {
            Thread thread = new Thread(() -> {
                for(int n=0; n<numberOfIncrements; n++) {
                    counter.increment();
                }
            });
            thread.start();
            threads.add(thread);
        }
        
        for(Thread thread : threads) {
            thread.join();
        }

        System.out.println(counter.getCount());
    }
    
}

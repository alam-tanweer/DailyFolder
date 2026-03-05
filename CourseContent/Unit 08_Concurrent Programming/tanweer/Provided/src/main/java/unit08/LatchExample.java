package unit08;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class LatchExample {
    public static void main(String[] args) {
        CountDownLatch gate = new CountDownLatch(1);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 3; i++) {
            int id = i + 1;
            executor.submit ( () -> {
                System.out.println(("Goat " + id + " is waiting at the gate."));
                try {
                    gate.await(); // Wait for the gate to open
                } catch (InterruptedException e) {}
                System.out.println("Goat " + id + " has passed through the gate.");
            });
        }

        System.out.println("Opening the gate...");
        gate.countDown(); // Open the gate
        executor.shutdown();
    }
}

package unit11.examples;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TollBoothExample {

    private static final int NUM_CARS = 3;

    private static final Lock gate = new ReentrantLock();
    private static final Condition open = gate.newCondition();

    private static class Car {
        private final String plate;

        public Car(String plate) {
            this.plate = plate;
        }

        public void payToll() {
            try {
                gate.lock();
                System.out.println("Car " + plate + " payed the toll.");
                open.awaitUninterruptibly();
                System.out.println("Car " + plate + " left the tollbooth");
            }finally { gate.unlock(); }
        }
    }

    public static void main (String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < NUM_CARS; i++) {
            Thread.sleep (100);
            exec.execute(new Car("" + i)::payToll);
        }
        exec.shutdown();
        
        Thread.sleep (1000);
        for (int i = 0; i < NUM_CARS; i++) {
            try {
                gate.lock();
                open.signal();
            } finally { gate.unlock (); }
        }
    }
    
}

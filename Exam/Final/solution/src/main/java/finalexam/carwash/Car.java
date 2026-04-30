package finalexam.carwash;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Car implements Runnable {
    private String carId;
    private int washTime;
    private CarWash carWash;

    private Lock lock;
    private Condition condition;
    private CountDownLatch startLatch;

    public Car(String carId, int washTime, CarWash carWash,
               Lock lock, Condition condition, CountDownLatch startLatch) {
        this.carId = carId;
        this.washTime = washTime;
        this.carWash = carWash;
        this.lock = lock;
        this.condition = condition;
        this.startLatch = startLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Car " + carId + " arrives");

            // signal ready
            startLatch.countDown();
            startLatch.await();

            lock.lock();
            try {
                while (!carWash.hasBay()) {
                    System.out.println("Car " + carId + " waiting for bay");
                    condition.await();
                }

                carWash.enter(carId);
                System.out.println("Car " + carId + " starts washing for " + washTime + " sec");

            } finally {
                lock.unlock();
            }

            Thread.sleep(washTime * 1000);

            lock.lock();
            try {
                carWash.exit();
                System.out.println("Car " + carId + " leaves");
                condition.signalAll();
            } finally {
                lock.unlock();
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

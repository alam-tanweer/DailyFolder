package finalexam.carwash;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarWashMain {
    public static void main(String[] args) throws InterruptedException {
        CarWash carWash = new CarWash(2);

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        int numCars = 5;
        CountDownLatch latch = new CountDownLatch(numCars);

        // ExecutorService executor = Executors.newFixedThreadPool(numCars);
        ExecutorService executor = Executors.newCachedThreadPool();
        Random rand = new Random();

        for (int i = 1; i <= numCars; i++) {
            int time = rand.nextInt(3) + 1;
            executor.execute(new Car("C" + i, time, carWash, lock, condition, latch));
        }

        System.out.println("Car wash is open!");

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Car wash is closed");
    }
}

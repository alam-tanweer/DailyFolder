package mte.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerTask implements Runnable {
    private final int taskId;
    private static final CountDownLatch startSignal =  new CountDownLatch(1);;
    private final Random random = new Random();

    public WorkerTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            // Wait until all threads are allowed to start together
            startSignal.await();

            System.out.println("Task " + taskId + " started by " + Thread.currentThread().getName());

            // Sleep for a random amount of time between 500 and 3000 ms
            int sleepTime = 500 + random.nextInt(2501);
            Thread.sleep(sleepTime);

            System.out.println("Task " + taskId + " completed by " + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Task " + taskId + " was interrupted.");
        } finally {
            // Notify main thread that this task is finished
        }
    }

    public static void main(String[] args) {
            int numberOfTasks = 5;

            ExecutorService executorService = Executors.newCachedThreadPool();

            // Create 5 threads with different task IDs
            for (int i = 0; i < numberOfTasks; i++) {
                WorkerTask task = new WorkerTask(i + 1);
                executorService.submit(task);
            }

            System.out.println("All worker threads created. Releasing them now...");

            executorService.shutdown();
            // Release all threads so they can start at the same time
            startSignal.countDown();

            try {
                // Wait until all tasks are completed
                executorService.awaitTermination(1, TimeUnit.DAYS);
                System.out.println("All tasks completed.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Main thread was interrupted.");
            }
        }    
}

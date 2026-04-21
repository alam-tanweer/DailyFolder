package mte.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerTask extends Thread {

    private int taskId;

    public WorkerTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + this.taskId + " started");

        // simulate work
        Random random = new Random();
        int sleepDuration = random.nextInt(1000, 20000);
        try {
            Thread.sleep(sleepDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task " + this.taskId + " completed");
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            // submit the task - execute or submit?
            Thread thread = new Thread(new WorkerTask(i));
            threads.add(thread);
        }

        // start all threads
        for (Thread thread : threads) {
            thread.start();
        }
        
        // wait for all threads to join
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("All tasks completed");
    }
}

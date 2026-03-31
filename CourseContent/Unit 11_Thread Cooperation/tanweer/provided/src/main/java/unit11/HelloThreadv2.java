package unit11;

import java.util.ArrayList;
import java.util.List;

public class HelloThreadv2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello, world!");
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            HelloThreadv1 hello = new HelloThreadv1();
            Thread thread = new Thread(hello);
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                // squash
            }
        }

        System.out.println("Goodbye!");
    }
}

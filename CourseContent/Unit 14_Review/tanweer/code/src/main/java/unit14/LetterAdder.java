package unit14;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LetterAdder {
    private final Map<Character,Integer> letterCounts;
    private final Lock lock;

    public LetterAdder(Map<Character,Integer> letterCounts,Lock lock) {
        this.letterCounts = letterCounts;
        this.lock = lock;
    }

    public void run() {
        for (char c = 'A'; c <= 'Z'; c++) {
            try {
                lock.lock();
                if (!letterCounts.containsKey(c))
                    letterCounts.put(c,0);

                letterCounts.put(c,letterCounts.get(c)+1);
            } finally {
                lock.unlock();
            }

            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Map<Character, Integer> letterCounts = new HashMap<>();

        Lock lock = new ReentrantLock();
        ExecutorService execSvc = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            LetterAdder adder = new LetterAdder(letterCounts, lock);
            execSvc.execute(adder::run);
        }

        execSvc.shutdown();
        execSvc.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println(letterCounts);
    }
}

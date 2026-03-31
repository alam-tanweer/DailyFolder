package unit11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock implements Runnable {

    private final String name;
    private final Lock lockOne;
    private final Lock lockTwo;

    public Deadlock(String name, Lock lockOne, Lock lockTwo) {
        this.name = name;
        this.lockOne = lockOne;
        this.lockTwo = lockTwo;
    }

    @Override
    public void run() {
        while(true) {
            System.out.println(name + " getting lock on " + lockOne);
            lockOne.lock();
            try {
                System.out.println(name + " got lock! Getting lock on " + lockTwo);
                lockTwo.lock();
                try {
                    System.out.println(name + " got both locks! Releasing " + lockTwo);
                } finally {
                    lockTwo.unlock();
                }
                System.out.println(name + " releasing " + lockOne);
            } finally {
                lockOne.unlock();
            }
        }
    }
    
    public static void main(String[] args) {
        Lock lockA = new ReentrantLock();
        Lock lockB = new ReentrantLock();

        new Thread(new Deadlock("DL1", lockA, lockB)).start();
        new Thread(new Deadlock("DL2", lockB, lockA)).start();
    }
}

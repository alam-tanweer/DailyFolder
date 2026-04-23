package unit14.dragonball;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Dragon implements Runnable {
    private final Cannon cannon;
    private final Color color;
    private final Lock cannonLock;
    private final Condition colorCondition;

    public Dragon(Color color, Cannon cannon, Lock cannonLock, Condition colorCondition) {
        this.cannon = cannon;
        this.color = color;
        this.cannonLock = cannonLock;
        this.colorCondition = colorCondition;
    }

    @Override
    public void run() {
        try {
            while (true) {
                cannonLock.lock();
                while (!cannon.isEmpty() && cannon.peek() != color) {
                    try {
                        System.out.println(this + " waits for " + color + " fireball...");
                        colorCondition.await();
                    } catch (InterruptedException e) { e.printStackTrace(); }
                }

                colorCondition.signalAll();
                if (cannon.isEmpty()) {
                    System.out.println("Cannon is empty! " + this + " is done.");
                    break;
                }
                
                System.out.println(this + " catches " + cannon.fire() + " fireball!");
                colorCondition.signalAll();

                cannonLock.unlock();
            }

        } finally {
            cannonLock.unlock();
        }
    }

    @Override
    public String toString() {
        return color + " Dragon";
    }

}

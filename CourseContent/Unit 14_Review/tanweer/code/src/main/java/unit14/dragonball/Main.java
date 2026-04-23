package unit14.dragonball;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_FIREBALLS = 5;
        Cannon cannon = new Cannon(NUMBER_OF_FIREBALLS);
        Lock cannonLock = new ReentrantLock();
        Condition colorCondition = cannonLock.newCondition();

        for (Color color : Color.values()) {
            Thread dragon = new Thread(new Dragon(color, cannon, cannonLock, colorCondition));
            dragon.start();
        }
    }
}

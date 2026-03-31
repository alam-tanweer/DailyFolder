package unit11;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Pottyv2 {

    private int capacity = 100;
    private double messLevel;
    public final Lock door;

    public Pottyv2 () {
        door = new ReentrantLock();
    }

    public void use() {
        capacity -= 1;
        messLevel += 0.10;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getMessLevel() {
        return messLevel;
    }

    public Lock getDoor() {
        return door;
    }
    
}

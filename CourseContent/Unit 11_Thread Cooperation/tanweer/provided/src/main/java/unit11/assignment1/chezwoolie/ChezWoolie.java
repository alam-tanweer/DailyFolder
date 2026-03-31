package unit11.assignment1.chezwoolie;

import java.util.LinkedList;
import java.util.List;

public class ChezWoolie {
    public static final long WECOND = 1l;

    private List<Food> conveyor;
    private int dinerCount;

    public ChezWoolie() {
        conveyor = new LinkedList<>();
        dinerCount = 0;
    }

    public synchronized void enter() {
        dinerCount++;
        notify();
    }

    public synchronized void exit() {
        dinerCount--;
    }

    public synchronized int getDinerCount() {
        return dinerCount;
    }

    public Food retrieveFood() {
        synchronized(conveyor) {
            while(conveyor.isEmpty()) {
                try {
                    conveyor.wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }
            return conveyor.remove(0);
        }
    }

    public void serveFood(Food food) {
        synchronized(conveyor) {
            conveyor.add(food);
            conveyor.notifyAll();
        }
    }
}

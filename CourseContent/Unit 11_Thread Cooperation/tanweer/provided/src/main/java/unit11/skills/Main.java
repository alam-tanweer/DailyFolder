package unit11.skills;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final Random RNG = new Random(1);

    private static Direction randomDirection() {
        switch(RNG.nextInt(4)) {
            case 0:
                return Direction.NORTH;
            case 1:
                return Direction.SOUTH;
            case 2:
                return Direction.EAST;
            case 3:
            default:
                return Direction.WEST;
        }
    }

    public static void main(String[] args) {
		Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ExecutorService executor = Executors.newCachedThreadPool();
		
        Intersection intersection = new Intersection(lock, condition);
        
		for(int i = 0; i < 10; i++) {
            long randomWait = RNG.nextInt(2000);
            try {
                Thread.sleep(randomWait);
            } catch (InterruptedException e) {
                // squash
            }
            Vehicle vehicle = new Vehicle(randomDirection(), intersection);
			executor.submit(vehicle::drive);
        }
		
		executor.shutdown();
    }
    
}
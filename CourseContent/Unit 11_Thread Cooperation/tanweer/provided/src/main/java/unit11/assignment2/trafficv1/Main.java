package unit11.assignment2.trafficv1;

import java.util.Random;

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
        Intersection intersection = new Intersection();
        for(int i=0; i<10; i++) {
            long randomWait = RNG.nextInt(2000);
            try {
                Thread.sleep(randomWait);
            } catch (InterruptedException e) {
                // squash
            }
            Vehicle vehicle = new Vehicle(randomDirection(), intersection);
            new Thread(vehicle).start();
        }   
    }
    
}

package unit11.assignment22235.trafficv1;

public class Vehicle implements Runnable {
    private static int NEXT_ID = 1;

    private final int id;
    private final Direction direction;
    private final Intersection intersection;

    public Vehicle(Direction direction, Intersection intersection) {
        this.id = NEXT_ID++;
        this.direction = direction;
        this.intersection = intersection;
    }

    @Override
    public void run() {
        intersection.driveThrough(this);        
    }

    public Direction getDirection() {
        return direction;
    }

    public int getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Vehicle (" + id + ") headed " + direction;
    }
    
}

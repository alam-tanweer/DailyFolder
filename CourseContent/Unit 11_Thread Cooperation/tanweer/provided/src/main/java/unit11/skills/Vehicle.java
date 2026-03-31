package unit11.skills;

public class Vehicle {
    private static int NEXT_ID = 1;

    private final int id;
    private final Direction direction;
    private final Intersection intersection;

    public Vehicle(Direction direction, Intersection intersection) {
        this.id = NEXT_ID++;
        this.direction = direction;
        this.intersection = intersection;
    }

    public void drive() {
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
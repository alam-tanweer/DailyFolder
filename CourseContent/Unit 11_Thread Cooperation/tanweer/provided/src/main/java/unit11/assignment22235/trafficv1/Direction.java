package unit11.assignment22235.trafficv1;

public enum Direction {
    NORTH("North"),
    SOUTH("South"),
    EAST("East"),
    WEST("West");

    private final String description;

    private Direction(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}

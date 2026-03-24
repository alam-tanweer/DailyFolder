package bbb.model;

public enum Direction {
    HORIZONTAL,
    VERTICAL;

    public static Direction getRandomDirection() {
        return Math.random() < 0.5 ? HORIZONTAL : VERTICAL;
    }
}

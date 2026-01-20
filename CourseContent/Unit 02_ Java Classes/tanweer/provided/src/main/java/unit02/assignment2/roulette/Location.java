package unit02.assignment2.roulette;

public class Location {
    private final int number;
    private final Color color;

    public Location (int number, Color color) {
        this.number = number;
        this.color = color;
    }

    @Override
    public String toString() {
        return "[" + number + ":" + color.toString().charAt (0) + "]";
    }

    public Color getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }
}

package unit04.swb;

public enum DamageType {
    NORMAL("Red"),
    HEAVY("Green"),
    ION("Blue");

    private String color;
    private DamageType(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name() + " (" + color + ")";
    }
}

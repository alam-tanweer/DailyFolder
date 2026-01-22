package unit02.swb;

public enum DamageType {
    //2.9
    // NORMAL,
    // HEAVY,
    // ION

    NORMAL("Red"),
    HEAVY("Green"),
    ION("Blue");  // Requires ; here

    private String color;
    private DamageType(String color){
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

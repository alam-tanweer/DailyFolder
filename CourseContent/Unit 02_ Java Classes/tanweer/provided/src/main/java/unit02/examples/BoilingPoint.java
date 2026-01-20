package unit02.examples;

public enum BoilingPoint {
    CELSIUS('C', 100),
    FAHRENHEIT('F', 212),
    KELVIN('K', 373.5f);

    private char scale;
    private float degrees;

    private BoilingPoint(char scale, float degrees) {
        this.scale = scale;
        this.degrees = degrees;
    }

    public char getScale() {
        return scale;
    }

    public float getDegrees() {
        return degrees;
    }

    @Override
    public String toString() {
        return degrees + " degrees " + scale;
    }
}

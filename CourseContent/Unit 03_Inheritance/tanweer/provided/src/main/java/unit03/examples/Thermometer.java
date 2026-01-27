package unit03.examples;

public abstract class Thermometer {
    private double degrees;

    public Thermometer(double degrees) {
        this.degrees = degrees;
    }

    public double getTemperature() {
        return degrees;
    }

    public void setTemperature(double degrees) {
        this.degrees = degrees;
    }

    public abstract double getFreezingPoint();

    public abstract double getBoilingPoint();

    public abstract char getScale();

    public static void main(String[] args) {
        
        // Thermometer t = new Thermometer(100);





        // double boiling = t.getBoilingPoint();
        // char scale = t.getScale();

    }
}

package unit03.examples;

public class Celsius extends Thermometer {

    public Celsius(double degrees) {
        super(degrees);
    }

    @Override
    public double getFreezingPoint() {
        return 0;
    }

    @Override
    public double getBoilingPoint() {
        return 100;
    }

    @Override
    public char getScale() {
        return 'C';
    } 
}

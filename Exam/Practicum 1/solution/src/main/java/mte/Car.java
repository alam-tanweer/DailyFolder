package mte;

public class Car extends Vehicle {

    private final double milesDriven;
    private final double gallonsUsed;

    public Car(String name, double milesDriven, double gallonsUsed) {
        super(name);
        this.milesDriven = milesDriven;
        this.gallonsUsed = gallonsUsed;
    }

    // efficiency = miles / gallons
    @Override
    public double getFuelEfficiency() {
        return milesDriven / gallonsUsed;
    }
}


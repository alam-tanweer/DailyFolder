package mte;

public class Car extends Vehicle{
    public Car(String name){
        super(name);
    }
    public void calculateFuelEfficiency(double milesDriven, double gallonsUsed){
        super.setFuelEfficiency(milesDriven / gallonsUsed);
    }
}

package mte.midterm;

public class Car extends Vehicle {

    public Car(String name, double milesDriven, double gallonsUsed){
        super(name,milesDriven,gallonsUsed);
        setRating(calculateFuelEfficiency());
    }

    public double calculateFuelEfficiency() {
        return getMpg();
    }
}

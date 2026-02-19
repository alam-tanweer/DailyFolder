package mte.midterm;

public class Truck extends Vehicle {
    private double cargoWeight;

    public Truck(String name, double milesDriven, double gallonsUsed, double cargoWeight){
        super(name,milesDriven,gallonsUsed);
        this.cargoWeight = cargoWeight;
        setRating(calculateFuelEfficiency());
    }

    public double calculateFuelEfficiency() {
        return getMpg()-(cargoWeight/1000);
    }
}
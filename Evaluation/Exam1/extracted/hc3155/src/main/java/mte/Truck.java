package mte;

public class Truck extends Vehicle{
    private double cargoWeight;
    public Truck(String name, double cargoWeight){
        super(name);
        this.cargoWeight = cargoWeight;
    }
    public void setCargoWeight(double cargoWeight){
        this.cargoWeight = cargoWeight;
    }
    public void calculateFuelEfficiency(double milesDriven, double gallonsUsed){
        super.setFuelEfficiency((milesDriven / gallonsUsed) - (cargoWeight / 1000));
    }
}

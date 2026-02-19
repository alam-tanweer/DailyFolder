package mte;

public abstract class Vehicle {
    private String name;
    private int fuelEfficieny;
    private int milesDriven;
    private int gallonsUsed;

    public Vehicle(String name){
        this.name = name;
    }
    public abstract int fuelEfficieny();

}

package mte.Vehicles;

public abstract class Vehicle {

    private String name;
    private int fuelef;

    public Vehicle(String name, int fuelef){
        this.name = name;
        this.fuelef = fuelef;
    }

    public String fuelEfficiancy(){
        return "The fuel efficiancy is:" + fuelef;
    }

    public String modelName(){
        return "the name of the car is: " + name;
    }
}

package mte;

public abstract class Vehicle {
    private String name;
    private double fuelEfficiency = 0;
    public abstract void calculateFuelEfficiency(double milesDriven, double gallonsUsed);
    public Vehicle(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public double getMPG(){
        return fuelEfficiency;
    }
    public void setFuelEfficiency(double fuelEfficiency){
        this.fuelEfficiency=fuelEfficiency;
    }
    @Override
    public String toString(){
        return "Name: " + name + ", Fuel Efficiency: " + fuelEfficiency;
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Vehicle other){
            return this.name.equals(other.getName()) && this.fuelEfficiency == other.getMPG();
        }
        return false;
    }
}

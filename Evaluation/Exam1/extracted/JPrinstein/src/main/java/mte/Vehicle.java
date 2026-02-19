package mte;

public abstract class Vehicle {
    String name;
    double fuelEfficiency;

    public Vehicle(String name, double fuelEfficiency){
        this.name = name;
        this.fuelEfficiency = fuelEfficiency;
    }

    public String getName(){
        return name;
    }

    abstract double getFuelEfficiency();

    @Override
    public String toString(){
        return "Name: " + name + "\nFuel Efficiency: " + getFuelEfficiency();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Vehicle other){
            return (this.name == other.name && this.fuelEfficiency == other.fuelEfficiency);
        }
        else{
            return false;
        }
    }
}

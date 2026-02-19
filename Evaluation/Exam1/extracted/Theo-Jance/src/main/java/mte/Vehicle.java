package mte;

public abstract class Vehicle {
    private String name;
    private double miles_driven;
    private double gallons_used;

    public Vehicle(String name, double miles_driven, double gallons_used){
        this.name = name;
        this.miles_driven = miles_driven;
        this.gallons_used = gallons_used;
    }

    public double getMilesDriven(){
        return miles_driven;
    }

    public double getGallonsUsed(){
        return gallons_used;
    }

    public abstract double fuelEfficiency();

    @Override
    public String toString(){
        return "name: " + name + " fuel efficiency: " + fuelEfficiency();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Vehicle other){
            return other.name == name & other.fuelEfficiency() == fuelEfficiency();
        }else{
            return false;
        }
    }
}

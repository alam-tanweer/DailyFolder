package mte;

public class Truck extends Vehicle{
    String name;
    double fuelEfficiency;

    int baseMPG;
    int cargoWeight;

    public Truck(String name, int baseMPG, int cargoWeight){
        super(name,(baseMPG-(cargoWeight/1000)));
        this.baseMPG = baseMPG;
        this.cargoWeight = cargoWeight;
    }

    public double getFuelEfficiency(){
        fuelEfficiency = baseMPG-((double)cargoWeight/1000);
        return fuelEfficiency;
    }
}

package mte;

public class Van extends Vehicle{
    String name;
    double fuelEfficiency;

    int baseMPG;
    int numOfPassengers;

    public Van(String name, int baseMPG, int numOfPassengers){
        super(name,(baseMPG-(numOfPassengers*0.5)));
        this.baseMPG = baseMPG;
        this.numOfPassengers = numOfPassengers;
    }

    public double getFuelEfficiency(){
        fuelEfficiency = baseMPG-(numOfPassengers*0.5);
        return fuelEfficiency;
    }
}

package mte;

public class Truck extends Vehicle{
    private String name;
    private int fuelEfficieny;
    private int milesDriven;
    private int gallonsUsed;
    private int cargoWeight;

    public Truck(String name, int milesDriven, int gallonsUsed, int cargoWeight){
        super(name);
        this.name = name;
        this.milesDriven = milesDriven;
        this.gallonsUsed = gallonsUsed;
        this.cargoWeight = cargoWeight;
        this.fuelEfficieny = (this.milesDriven/this.gallonsUsed) - (this.cargoWeight/1000);
    }

    public String getName(){
        return name;
    }

    public int getMilesDriven(){
        return milesDriven;
    }

    public int getGallonsUsed(){
        return gallonsUsed;
    }

    public int getCargoWeight(){
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight){
        this.cargoWeight = cargoWeight;
    }

    public int fuelEfficieny(){
        return fuelEfficieny;
    }

    public String toString(){
        return name + " with fuel efficiency: " + fuelEfficieny;
    }

    // public boolean equals(Object obj){
    //     if (obj instanceof Vehicle other){
    //         return (this.name == other.name && this.fuelEfficieny == other.fuelEfficieny)
    //     }
    //     else{
    //         return false;
    //     }
    // }
}

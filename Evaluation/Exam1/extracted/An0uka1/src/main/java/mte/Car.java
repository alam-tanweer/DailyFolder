package mte;

public class Car extends Vehicle{
    private String name;
    private int fuelEfficieny;
    private int milesDriven;
    private int gallonsUsed;

    public Car(String name, int milesDriven, int gallonsUsed){
        super(name);
        this.name = name;
        this.milesDriven = milesDriven;
        this.gallonsUsed = gallonsUsed;
        this.fuelEfficieny = (this.milesDriven / this.gallonsUsed);
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

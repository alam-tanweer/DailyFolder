package mte;

public class Van extends Vehicle{
    private String name;
    private int fuelEfficieny;
    private int milesDriven;
    private int gallonsUsed;
    private int numberOfPassengers;

    public Van(String name, int milesDriven, int gallonsUsed, int numberOfPassengers){
        super(name);
        this.name = name;
        this.milesDriven = milesDriven;
        this.gallonsUsed = gallonsUsed;
        this.numberOfPassengers = numberOfPassengers;
        this.fuelEfficieny = (this.milesDriven/this.gallonsUsed) - (this.numberOfPassengers * (1/2));
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

    public int getNumberOfPassengers(){
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers){
        this.numberOfPassengers = numberOfPassengers;
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

    public static void main(String[] args) {
        Van v1 = new Van("van", 20, 2, 4);
        v1.fuelEfficieny();
        System.out.println(v1);
        System.out.println(v1.getGallonsUsed());
        System.out.println(v1.getMilesDriven());
    }

}

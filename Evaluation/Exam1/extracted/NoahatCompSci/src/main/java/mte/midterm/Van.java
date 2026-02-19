package mte.midterm;

public class Van extends Vehicle {
    private int passengers;

    public Van(String name, double milesDriven, double gallonsUsed, int passengers){
        super(name,milesDriven,gallonsUsed);
        this.passengers = passengers;
        setRating(calculateFuelEfficiency());
    }

    public double calculateFuelEfficiency() {
        return getMpg()-(passengers*0.5);
    }
}
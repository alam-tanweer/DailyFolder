package mte;

public class Van extends Vehicle{
    private int numPassengers;
    public Van(String name, int numPassengers){
        super(name);
        this.numPassengers = numPassengers;
    }
    public void calculateFuelEfficiency(double milesDriven, double gallonsUsed){
        super.setFuelEfficiency((milesDriven / gallonsUsed) - (numPassengers * 0.5));
    }
}

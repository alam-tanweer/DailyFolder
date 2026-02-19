package mte;

public class Van extends Vehicle {

    private int nPassengers;
    private int baseMPG;

    public Van(String name, int nPassengers, int baseMPG) {
        super(name);
        this.nPassengers = nPassengers;
        this.baseMPG = baseMPG;
    }

    @Override
    public int calculateFuelEfficiency() {
        return (int) (this.baseMPG - (this.nPassengers * 0.5));
    }

}

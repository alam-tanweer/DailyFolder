package mte;

public class Truck extends Vehicle {

    private int cargo_weight;
    private int baseMPG;

    public Truck(String name, int cargo_weight, int baseMPG) {
        super(name);
        this.cargo_weight = cargo_weight;
        this.baseMPG = baseMPG;
    }

    @Override
    public int calculateFuelEfficiency() {
        return this.baseMPG - (this.cargo_weight / 1000);
    }

}

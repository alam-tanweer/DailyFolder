package practicum01;

public class Truck extends Vehicle {

    private final double baseMPG;
    private final double cargoWeight;

    public Truck(String name, double baseMPG, double cargoWeight) {
        super(name);
        this.baseMPG = baseMPG;
        this.cargoWeight = cargoWeight;
    }

    // efficiency = base MPG − (cargo weight / 1000)
    @Override
    public double getFuelEfficiency() {
        return baseMPG - (cargoWeight / 1000.0);
    }
}


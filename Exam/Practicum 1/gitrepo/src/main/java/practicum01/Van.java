package practicum01;

public class Van extends Vehicle {

    private final double baseMPG;
    private final int passengers;

    public Van(String name, double baseMPG, int passengers) {
        super(name);
        this.baseMPG = baseMPG;
        this.passengers = passengers;
    }

    // efficiency = base MPG − (passengers × 0.5)
    @Override
    public double getFuelEfficiency() {
        return baseMPG - (passengers * 0.5);
    }
}


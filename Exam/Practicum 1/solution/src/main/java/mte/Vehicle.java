package mte;

import java.util.Objects;

public abstract class Vehicle implements EfficiencyRated {

    private final String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract double getFuelEfficiency();

    @Override
    public String toString() {
        return name + " efficiency = "
                + String.format("%.2f", getFuelEfficiency());
    }

    // equality based on name + fuel efficiency
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle v = (Vehicle) o;

        return Objects.equals(name, v.name)
                && Double.compare(getFuelEfficiency(),
                                  v.getFuelEfficiency()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getFuelEfficiency());
    }
}


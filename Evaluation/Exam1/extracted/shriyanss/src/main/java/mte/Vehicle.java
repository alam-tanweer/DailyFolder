package mte;

public abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    

    abstract public int calculateFuelEfficiency();

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        // should return its name and fuel efficiency
        return this.name + "; " + calculateFuelEfficiency();
    }

    @Override
    public boolean equals(Object obj) {
        // same name and same fuel efficiency
        if (obj instanceof Vehicle) {
            Vehicle otherVehicle = (Vehicle) obj;

            return this.getName() == otherVehicle.getName() && otherVehicle.calculateFuelEfficiency() == this.calculateFuelEfficiency();
        }
        return false;
    }

    

    
}

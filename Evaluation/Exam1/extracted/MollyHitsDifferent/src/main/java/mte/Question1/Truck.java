package mte.Question1;

public class Truck extends Vehicle {
    public Truck(String name, int mileage, int galUsed, int cargoInput) {
        super(name, mileage, galUsed);
        this.fuelEffic = this.fuelEffic - (cargoInput / 1000);
    }

    public boolean equals(Vehicle other) {
        return other.getEffic() == this.fuelEffic && other.getName() == this.name;
    }

}
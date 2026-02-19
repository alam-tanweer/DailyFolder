package mte.Question1;

public class Van extends Vehicle {
    public Van(String name, int mileage, int galUsed, int passenger) {
        super(name, mileage, galUsed);
        this.fuelEffic = this.fuelEffic - (passenger / 2);
    }

    public boolean equals(Vehicle other) {
        return other.getEffic() == this.fuelEffic && other.getName() == this.name;
    }
}
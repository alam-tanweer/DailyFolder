package mte;

public class Truck extends Vehicle {
    
    public Truck(String name, double mpg, double cargoWeight) {
        super(name, (mpg - (cargoWeight / 1000)));
    }
}

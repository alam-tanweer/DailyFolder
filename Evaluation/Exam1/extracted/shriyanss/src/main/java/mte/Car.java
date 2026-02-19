package mte;

public class Car extends Vehicle {

    private int miles_driven;
    private int gallons_used;

    public Car(String name, int miles_driven, int gallons_used) {
        super(name);
        this.miles_driven = miles_driven;
        this.gallons_used = gallons_used;
    }

    @Override
    public int calculateFuelEfficiency() {
        return miles_driven/gallons_used;
    }
    

}

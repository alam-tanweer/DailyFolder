package mte;

public class Car extends Vehicle {

    public Car(String name, double miles_driven, double gallons_used) {
        super(name, (miles_driven/gallons_used));
    }


}

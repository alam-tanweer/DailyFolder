package mte;

public class Car extends Vehicle{
    public Car(double miles_driven, double gallons_used){
        super("Car", miles_driven, gallons_used);
    }

    @Override
    public double fuelEfficiency(){
        return getMilesDriven() * getGallonsUsed();
    }
}

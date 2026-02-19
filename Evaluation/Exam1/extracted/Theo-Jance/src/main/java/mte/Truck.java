package mte;

public class Truck extends Vehicle{
    private double cargo_weight;
    public Truck(double miles_driven, double gallons_used, double cargo_weight){
        super("Truck", miles_driven, gallons_used);
        this.cargo_weight = cargo_weight;
    }

    @Override
    public double fuelEfficiency(){
        return (getMilesDriven() * getGallonsUsed()) - (cargo_weight/1000);
    }
}

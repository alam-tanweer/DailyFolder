package mte;

public class Van extends Vehicle{
    private int passengers;

    public Van(double miles_driven, double gallons_used, int passengers){
        super("Van", miles_driven, gallons_used);
        this.passengers = passengers;
    }

    @Override
    public double fuelEfficiency(){
        return (getMilesDriven() * getGallonsUsed()) - (passengers * 0.5);
    }
}

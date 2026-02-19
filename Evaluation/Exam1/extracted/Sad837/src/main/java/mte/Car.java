package mte;

public class Car extends Vehicle {
    private int miles;
    private double gallons;


    public Car(double erating ) {
        
        super("Car", erating);
        this.erating = miles/gallons;
    }

    @Override
    public String getName(){return name;}
    @Override
    public double getErating(){return erating;}
    @Override
    public boolean equals(Object o) {
        // TODO Auto-generated method stub
        return super.equals(o);
    }

    @Override
    public  String toString(){
        return "Car:  " + getName() + "Fuel Efficiency: " + getErating();
    }

    
}

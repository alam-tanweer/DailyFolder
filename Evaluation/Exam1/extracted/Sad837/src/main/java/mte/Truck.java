package mte;

public class Truck extends Vehicle {
    private double cargoweight;
    public Truck(double erating, double cargoweight) {
        super("Truck", erating);
        this.erating = erating - cargoweight/1000;
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
        return "Truck:  " + getName() + "Fuel Efficiency: " + getErating();
    }
}

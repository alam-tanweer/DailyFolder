package mte.midterm;

public class Truck extends Vehicle {
    private float baseMPG;
    private float cargoWeight;

    public Truck(float cargoWeight, float baseMPG){
        super("truck");
        this.cargoWeight = cargoWeight;
        this.baseMPG = baseMPG;
    }

    public float getFuelEfficieny(){
        return (baseMPG - (cargoWeight/1000)); 
    }
    @Override
    public String toString(){
        return "Name: truck | fuel efficiency: " + this.getFuelEfficieny() + " mpg";
    }

     @Override
    public boolean equals(Object obj){
        if (obj instanceof Truck){
            Truck other = (Truck) obj;
            return (this.getFuelEfficieny()==other.getFuelEfficieny());
        }
        else{
            return false;
        }
    
}

    
}
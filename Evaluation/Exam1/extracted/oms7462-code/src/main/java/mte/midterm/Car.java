package mte.midterm;

public class Car extends Vehicle {
    private float milesDriven;
    private float gallonsUsed;

    public Car(float milesDriven, float gallonsUsed){
        super("car");
        this.milesDriven = milesDriven;
        this.gallonsUsed = gallonsUsed;
    }

    public float getFuelEfficieny(){
        return (milesDriven/gallonsUsed);
    }
    
    @Override
    public String toString(){
        return "Name: car | fuel efficiency: " + this.getFuelEfficieny() + " mpg";
    }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Car){
            Car other = (Car) obj;
            return (this.getFuelEfficieny()==other.getFuelEfficieny());
        }
        else{
            return false;
        }
    
}

    
}

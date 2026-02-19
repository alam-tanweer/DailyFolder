package mte.midterm;

public class Van extends Vehicle {
    private float baseMPG;
    private int numPassengers;

    public Van(int numPassengers, float baseMPG){
        super("van");
        this.numPassengers = numPassengers;
        this.baseMPG = baseMPG;
    }

    public float getFuelEfficieny(){
        return (float)(baseMPG - (numPassengers * 0.5)); 
    }
    @Override
    public String toString(){
        return "Name: van | fuel efficiency: " + this.getFuelEfficieny() + " mpg";
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Van){
            Van other = (Van) obj;
            return (this.getFuelEfficieny()==other.getFuelEfficieny());
        }
        else{
            return false;
        }
    
}
}

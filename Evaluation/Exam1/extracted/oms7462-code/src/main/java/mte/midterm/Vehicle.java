package mte.midterm;

public abstract class Vehicle {
    
    private String name;

    public Vehicle(String name){
        this.name = name;
    }

    public abstract float getFuelEfficieny();

    public String getName(){
        return this.name;
    }
    

    public String toString(){
        return "Name: " + this.getName() + " | fuel efficiency: " + this.getFuelEfficieny() + " mpg";
    }

    
    public boolean equals(Object obj){
        if (obj instanceof Vehicle){
            Vehicle other = (Vehicle) obj;
            return (this.name.equals(other.getName()) && this.getFuelEfficieny()==other.getFuelEfficieny());
        }
        else{
            return false;
        }
    }

    

    

    
}

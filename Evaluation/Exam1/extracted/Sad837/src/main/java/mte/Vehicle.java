package mte;

public abstract class Vehicle {
    protected String name;
    protected double erating;


    public Vehicle(String name, double erating){
        this.name = name;
        this.erating = 1000;
    
    }
    public String getName(){return name;}
    public double getErating(){return erating;}

    @Override
    public  String toString(){
        return "Vehicle:  " + getName() + "Fuel Efficiency: " + getErating();
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Vehicle ){
            Vehicle other = (Vehicle) o;
            return (name == other.name) && (erating == other.getErating());
        }
        else{return false;}
        
    }

    

    
    
}

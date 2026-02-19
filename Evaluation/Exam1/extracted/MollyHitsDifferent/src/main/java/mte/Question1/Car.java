package mte.Question1;

public class Car extends Vehicle {
    public Car(String name, int mileage, int galUsed){super(name,mileage,galUsed); }
    
    public boolean equals(Vehicle other){
        return other.getEffic() == this.fuelEffic && other.getName() == this.name;}
        
    
    

}

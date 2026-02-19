package mte.Question1;

public abstract class Vehicle {
    protected String name;
    protected int fuelEffic;
    protected int milesDriven;
    protected int galUsed;
    protected Vehicle(String name, int mileage, int gasGallon){
        this.fuelEffic = mileage/gasGallon;
        this.name = name;
        this.milesDriven = mileage;
        this.galUsed = gasGallon; 

    }
    
   

    public String getName(){return this.name;}
    public int getEffic(){return this.fuelEffic;}
// Part 2
        @Override
        public String toString() {return "Car Name: " + this.getName() + " Fuel efficieny rating: " + this.getEffic();}

    public static void main(String[] args) {
        // Vehicle[] lineUp = new Vehicle[5];
        Car fox = new Car("Volkswagon",32,1);
        Car box = new Car("Volkswagon",32,1);
        Truck mox = new Truck( "CatGirl",22, 30, 7000);
        Truck crox = new Truck("Jim", 22,33,7200);
        Van trots = new Van("Box", 3000,33,7);
        Vehicle[] lineUp = {fox,box,mox,crox,trots};
        int i = 0;
        while (i < lineUp.length ){
            System.out.println(lineUp[i]);
            i++;}
        System.out.println(fox.equals(box));
        
        
    }
    


}

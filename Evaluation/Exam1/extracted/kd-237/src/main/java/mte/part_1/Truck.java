package mte.part_1;

public class Truck implements Vehicle {
    private String name;
    private int fuel_rating;

    public Truck(String name, int fuel_rating){
        this.name = name;
        this.fuel_rating = fuel_rating;

    } 
    @Override
     public double fuel_effciency(int mpg, int cargo){
        fuel_rating = (mpg - (cargo/1000));
        return fuel_rating;
     }
      @Override
     public String toString(){
        return "Vehicle: " + name + " fuel effciency: " + fuel_rating;
     }
}

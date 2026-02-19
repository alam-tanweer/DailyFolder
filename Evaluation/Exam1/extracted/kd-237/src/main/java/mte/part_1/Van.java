package mte.part_1;

public class Van implements Vehicle {
    private String name;
    private int fuel_rating;

    public Van(String name, int fuel_rating){
        this.name = name;
        this.fuel_rating = fuel_rating;

    } 
    @Override
     public double fuel_effciency(int mpg, int passengers){
        this.fuel_rating = (int) (mpg - (passengers*0.5));
        return fuel_rating;
     }

     @Override
     public String toString(){
        return "Vehicle: " + name + " fuel effciency: " + fuel_rating;
     }
}


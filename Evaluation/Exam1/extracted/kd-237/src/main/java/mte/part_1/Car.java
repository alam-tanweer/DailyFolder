package mte.part_1;

import java.util.*;

public class Car implements Vehicle {
    private String name;
    private int fuel_rating;

    public Car(String name, int fuel_rating){
        this.name = name;
        this.fuel_rating = fuel_rating;

    } 
    @Override
     public double fuel_effciency(int miles, int gallons){
        fuel_rating = miles/gallons;
        return fuel_rating;
     }
      @Override
     public String toString(){
        return "Vehicle: " + name + " fuel effciency: " + fuel_rating;
     }

    @Override
    public boolean equals(Object obj){
        if (obj instanceof Car other){
            return (name.equals(other.name)) && (fuel_rating == other.fuel_rating);
        }
        else{
        return  false;
        }

    }
}

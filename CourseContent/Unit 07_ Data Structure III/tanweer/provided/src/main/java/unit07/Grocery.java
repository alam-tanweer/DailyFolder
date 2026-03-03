package unit07;

import unit07.sets.HashSet;
import unit07.sets.Set;

public class Grocery {
    private final String name;
    private final double weight;

    public Grocery(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     if (obj instanceof Grocery other) {
    //     return name.equals(other.name) && weight == other.weight;
    //     }
    //     return false;
    // }

    
    // public int hashCode() {
    //     return name.hashCode() * Double.valueOf(weight).hashCode();  
    // }

    @Override
    public String toString() {
        return name + " (" + weight + " oz)";
    }

    public static void main(String[] args) {

        Set<Grocery> grocerySet = new HashSet<>();
        
        for (int i = 0; i < 100; i++) {
            grocerySet.add (new Grocery("Diet Coke", 16.9));
        }

        grocerySet.add (new Grocery("Diet Coke", 70.55));

        System.out.println(grocerySet);
    }
}

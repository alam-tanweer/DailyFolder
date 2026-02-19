package unit06.assignment1.generic_bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pokemon implements Comparable<Pokemon> {
    private final int number;
    private final String name;
    
    public Pokemon(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }

    @Override
    public int compareTo(Pokemon o) {
        return this.number - o.number;
    }

    public static void main(String[] args) {
        List<Pokemon> pokemon = new ArrayList<>();
        pokemon.add(new Pokemon(4, "Charmander"));
        pokemon.add(new Pokemon(129, "Magikarp"));
        pokemon.add(new Pokemon(8, "Wartortle"));
        pokemon.add(new Pokemon(36, "Clefable"));

        Collections.sort(pokemon);
        System.out.println(pokemon);
        
    }
}

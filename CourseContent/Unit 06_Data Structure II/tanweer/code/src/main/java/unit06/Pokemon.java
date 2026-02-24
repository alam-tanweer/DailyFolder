package unit06;

import java.util.Collections;
import java.util.LinkedList;

public class Pokemon implements Comparable<Pokemon> {
    private final String name;
    private final int number;

    public Pokemon(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Pokemon o) {
        return this.number - o.number;

        //Code to implement by number and then by name
        // int numberCompare = this.number - o.number;
        // if (numberCompare != 0) {
        //     return numberCompare;
        // }
        // return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }

    public static void main(String[] args) {
        LinkedList<Pokemon> pokelist = new LinkedList<>();
        pokelist.add(new Pokemon("M",2));
        pokelist.add(new Pokemon("A",3));
        pokelist.add(new Pokemon("C",2));
        pokelist.add(new Pokemon("B",1));
        System.out.println(pokelist);

        Collections.sort(pokelist);
        System.out.println(pokelist);


    }
}

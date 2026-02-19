package unit06;

import java.util.Comparator;
import java.util.Collections;
import java.util.LinkedList;

public class PokemonComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon a, Pokemon b) {
        String aName = a.getName().toLowerCase();
        String bName = b.getName().toLowerCase();
        return aName.compareTo(bName);
    }

    public static void main(String[] args) {
        LinkedList<Pokemon> pokelist = new LinkedList<>();
        pokelist.add(new Pokemon("A",3));
        pokelist.add(new Pokemon("C",2));
        pokelist.add(new Pokemon("B",1));
        System.out.println(pokelist);
 
        Collections.sort(pokelist);
        System.out.println(pokelist);

        Collections.sort(pokelist, new PokemonComparator());
        System.out.println(pokelist);


    }

}

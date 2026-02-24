package unit06;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class PokemonComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon a, Pokemon b) {
        // String aName = a.getName().toLowerCase();
        // String bName = b.getName().toLowerCase();
        // return aName.compareTo(bName);

        int nameCompare = a.getName().compareToIgnoreCase(b.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }

        // Secondary sort: descending number
        return Integer.compare(b.getNumber(), a.getNumber());        
    }

    public static void main(String[] args) {
        LinkedList<Pokemon> pokelist = new LinkedList<>();
        pokelist.add(new Pokemon("A",4));
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

/*
[3: A, 4: A, 1: B, 2: C] why 4 is not first as it is added first.

Because of stable sorting.
Collections.sort() uses TimSort, which is stable.
Stable sort means:
If two elements compare as equal, their original order is preserved.

Grouped by name:

A → (3, 4)

B → (1)

C → (2)

BUT since sorting is stable:
Within the "A" group, it keeps the previous order:

[3: A, 4: A, 1: B, 2: C]

So 3 comes before 4 because that was their order before this sort.
*/

package unit04;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import unit04.gvt.Fighter;
import unit04.gvt.Goat;
import unit04.gvt.Mage;


public class Lecture {
    public static void main(String[] args) {
        Goat p1 = new Fighter("Thurstwig");
        Goat p2 = new Mage("Dendelion");
        Goat p3 = new Fighter("Player123456");
        Goat p4 = new Mage("MagesRock");

        Comparator<Goat> comp = new Comparator<Goat>(){
            @Override
            public int compare(Goat a, Goat b) {
                return a.getName().compareTo(b.getName());
            }
        };

        Set<Goat> party = new TreeSet<> (comp);

        party.add(p1);
        party.add(p2);
        party.add(p3);
        party.add(p4);

        System.out.println(party);
    }
}

package unit08.assignment_2215.woolies.part2;

import java.util.ArrayList;
import java.util.List;

public class Woolies {

    public static void main (String[] args) {
       List <Woolie> woolies = new ArrayList<>();
       Bridge troll = new Bridge ();
       woolies.add (new Woolie ("Bruce", 7, Woolie.city.MERCTRAN, troll)); 
       woolies.add (new Woolie ("Bobby", 8, Woolie.city.SICSTINE, troll)); 
       woolies.add (new Woolie ("Ahmed", 5, Woolie.city.MERCTRAN, troll)); 
       woolies.add (new Woolie ("Gahyun", 4, Woolie.city.SICSTINE, troll));
       woolies.add (new Woolie ("Tony", 10, Woolie.city.MERCTRAN, troll)); 
       woolies.add (new Woolie ("Chris", 6, Woolie.city.SICSTINE, troll));  

       for (int i = 0; i < 6; i++) {
           Thread thread = new Thread (woolies.get (i));
           thread.start ();
       }
    }
    
}

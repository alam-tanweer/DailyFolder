package unit08.assignment_2215.woolies.part1;

import java.util.ArrayList;
import java.util.List;

public class Woolies {

    public static void main (String[] args) {
       List <Woolie> woolies = new ArrayList<>();
       woolies.add (new Woolie ("Bruce", 7, Woolie.city.MERCTRAN)); 
       woolies.add (new Woolie ("Bobby", 8, Woolie.city.SICSTINE)); 
       woolies.add (new Woolie ("Ahmed", 5, Woolie.city.MERCTRAN)); 
       woolies.add (new Woolie ("Gahyun", 4, Woolie.city.SICSTINE));
       woolies.add (new Woolie ("Tony", 10, Woolie.city.MERCTRAN)); 
       woolies.add (new Woolie ("Chris", 6, Woolie.city.SICSTINE));  

       for (int i = 0; i < 6; i++) {
           Thread thread = new Thread (woolies.get (i));
           thread.start ();
       }
    }
    
}

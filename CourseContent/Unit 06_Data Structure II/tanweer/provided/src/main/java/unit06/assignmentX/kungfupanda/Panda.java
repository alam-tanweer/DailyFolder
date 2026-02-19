package unit06.assignmentX.kungfupanda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Panda<E>{
    private E weapon;
    private String name;

    public Panda(E wpn, String name){
        this.weapon = wpn;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public void strike(){
        //System.out.println( Arrays.toString(weapon.combo()) );
        if(weapon instanceof Fist){
            Fist w = (Fist)weapon;
            String out = Arrays.toString( w.combo() );
            System.out.println(out);
        }
        else if (weapon instanceof Flowers)
            System.out.println(weapon);
        else { //naginata
            Naginata n = (Naginata)weapon;
            System.out.println("Naginata strike!! " +  n.attack());
        }

    }
    
    public static ArrayList<String> unique(String[] names){
        HashSet<String> myset = new HashSet<String>();

        for(String s: names){
            if(! myset.contains(s)){
                myset.add(s);
            }
        }

        return new ArrayList<String>(myset);
    }
}




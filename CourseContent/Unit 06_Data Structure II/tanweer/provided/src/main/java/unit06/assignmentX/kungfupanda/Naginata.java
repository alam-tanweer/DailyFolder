package unit06.assignmentX.kungfupanda;

import java.util.Random;

public class Naginata {
    private final float dmg;

    Naginata(float dmg){
        this.dmg = dmg;
    }
    
    public double attack(){
        Random r = new Random();
        return dmg*r.nextDouble();
    }

    
}

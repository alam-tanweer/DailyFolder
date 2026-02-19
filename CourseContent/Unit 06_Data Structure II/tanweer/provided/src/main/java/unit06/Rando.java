package unit06;

import java.util.Random;

public class Rando extends Random {
    
    public Rando(int seed) {
        super(seed);
    }

    @Override
    public int nextInt() {
        int next = super.nextInt();
        System.out.println("  next int called: " + next);
        return next;
    }

    // @Override
    // public int nextInt(int bound) {
    //     int next = super.nextInt(bound);
    //     System.out.println("  next int called: " + next);
    //     return next;
    // }

    public static void main(String[] args) {
        Rando rando = new Rando(1);

        int next = rando.nextInt(1000, 1010);
        System.out.println("result: " + next);
    }
}

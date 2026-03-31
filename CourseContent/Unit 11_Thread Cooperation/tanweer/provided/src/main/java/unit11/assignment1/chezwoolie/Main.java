package unit11.assignment1.chezwoolie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final Random RNG = new Random(1);

    public static void main(String[] args) throws InterruptedException {
        ChezWoolie chezWoolie = new ChezWoolie();
        System.out.println("Chez Woolie is opening for the day!");

        List<Thread> threads = new ArrayList<>();
        for(int i=1; i<3; i++) {
            Chef chef = new Chef("#" + i, chezWoolie);
            Thread thread = new Thread(chef);
            thread.start();
            threads.add(thread);
        }

        for(int i=1; i<3; i++) {
            int hunger = RNG.nextInt(5) + 1;
            Diner diner = new Diner("#" + i, hunger, chezWoolie);
            Thread thread = new Thread(diner);
            thread.start();
        }

        for(Thread thread : threads) {
            thread.join();
        }
        System.out.println("Chez Woolie is closing for the night!");
    }
    
}

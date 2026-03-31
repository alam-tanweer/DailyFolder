package unit11.assignment12235.ggg;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import unit11.assignment12235.ggg.Goat.Color;

public class GreedyGreedyGoats {
    private static final int MARBLE_LIMIT = 250;

    private static void joinOnThread(Thread thread) {
        try {
            thread.join();
        } catch(InterruptedException e) {}
    }

    public static void main(String[] args) throws InterruptedException {
        Trough trough = new Trough(MARBLE_LIMIT);

        List<Goat> goats = Arrays.asList(Color.values())
            .stream()
            .map(c -> new Goat(c, trough))
            .collect(Collectors.toList());

        List<Thread> threads = goats.stream()
            .map(g -> new Thread(g))
            .collect(Collectors.toList());
        threads.forEach(Thread::start);

        TurnipDropper dropper = new TurnipDropper(trough);
        Thread dropperThread = new Thread(dropper);
        dropperThread.start();
        joinOnThread(dropperThread);

        threads.forEach(GreedyGreedyGoats::joinOnThread);

        System.out.println("The game is over! A total of " 
            + trough.getTurnipsSoFar() 
            + " turnips were dropped into the trough!");
        Collections.sort(goats, 
            (a, b) -> b.getTurnipsEaten() - a.getTurnipsEaten());
        int total = 0;
        for(Goat goat : goats) {
            int eaten = goat.getTurnipsEaten();
            total += eaten;
            System.out.println(goat + " ate " + eaten + " turnips!");
        }
        System.out.println("Together, the goats ate " + total + " turnips!");
    }
}

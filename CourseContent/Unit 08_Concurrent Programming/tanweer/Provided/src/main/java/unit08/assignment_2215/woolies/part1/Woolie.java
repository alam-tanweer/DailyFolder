package unit08.assignment_2215.woolies.part1;

public class Woolie implements Runnable {
    public enum city {
        MERCTRAN, SICSTINE
    }

    public static final int SECOND = 100;

    private String name;
    private int crossingTime;
    private city destination;

    public Woolie (String name, int crossingTime, city destination) {
        this.name = name;
        this.crossingTime = crossingTime;
        this.destination = destination;
    }

    @Override
    public void run() {
        System.out.println (name + " has arrived at the bridge.");
        for (int i = 0; i < crossingTime; i++) {
            if (i == 0) {
                System.out.println (name + " is starting to cross.");
            }
            else {
                System.out.println (String.format ("\t %s %d seconds.", name, i));
            }
            try {
                Thread.sleep (SECOND);
            } catch (InterruptedException ie) {/* Squash it */}
        }

        System.out.println (String.format ("%s leaves at %s.", name, destination));
    }

}

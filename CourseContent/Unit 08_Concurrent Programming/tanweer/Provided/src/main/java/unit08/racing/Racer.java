package unit08.racing;

import java.util.Random;

/** Activity 8.1  **/
public class Racer {
    private final int num_laps;
    private long time;
    private int lap;
    private String name;
    private final boolean debug;
    private static final Random rand = new Random();

    public Racer (String name, int numLaps, boolean debug) {
        this.name = name;
        this.num_laps = numLaps;
        this.debug = debug;
        lap = 0;
    }

    public Racer (String name, int num_laps) {
        this(name, num_laps, false);
    }

    public void race() {
        long start = System.nanoTime();
        for (int i = 0; i < num_laps; i++) {
            /** Activity 8.17 **/
            try {
                Thread.sleep(rand.nextInt(20, 100));
            } catch (InterruptedException e) {}
            lap++;
            if (debug) {
                System.out.println(name + " completed Lap " + lap);
            }
        }
        time = System.nanoTime() - start;
    }

    public int getLap() {
        return lap;
    }

    public double getFinishTime() {
        return time / 1_000_000_000.0;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Racer r1 = new Racer ("Mario", 10, true);

        r1.race();

        System.out.println (r1.getName() + " Finished in " + r1.getFinishTime() + " seconds");
    }

}

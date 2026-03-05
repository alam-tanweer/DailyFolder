package unit08.starter;

import java.util.Random;

public class Racer {
    private String name;
    private final int num_laps;
    private long time;
    private final boolean debug;
    private int lap;

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

    }

    public int getLap() {
        return lap;
    }

    public double getFinishTime() {
        return 0;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
    }
}

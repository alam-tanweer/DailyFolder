package unit08.racing;

import java.util.Random;

public class ThreadRacer extends Thread {
    private String name;
    private final int num_laps;
    private long time;
    private final boolean debug;

    private int lap;
    private static final Random rand = new Random();

    public ThreadRacer (String name, int numLaps, boolean debug) {
        this.name = name;
        this.num_laps = numLaps;
        this.debug = debug;
        lap = 0;
    }

    public ThreadRacer (String name, int num_laps) {
        this(name, num_laps, false);
    }

    public void race() {
        long start = System.nanoTime();
        for (int i = 0; i < num_laps; i++) {
            // /** Activity 8.17 **/
            // try {
            //     Thread.sleep(rand.nextInt(20, 100));
            // } catch (InterruptedException e) {}
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

    public String getRacerName() {
        return name;
    }

    @Override
    public void run(){
        race();
    }

    public static void main(String[] args) {
        ThreadRacer r1 = new ThreadRacer ("Mario", 20, true);

        r1.start();

        System.out.println (r1.getRacerName() + " Finished in " + r1.getFinishTime() + " seconds");
    }
}


package unit08.racing;

/** Activity 8.4 **/
public class ThreadRacer extends Thread {
    private final int num_laps;
    private long time;
    private int lap;
    private String name;
    private final boolean debug;

    public ThreadRacer (String name, int num_laps, boolean debug) {
        this.name = name;
        this.num_laps = num_laps;
        this.debug = debug;
        lap = 0;
    }

    public ThreadRacer (String name, int num_laps) {
        this(name, num_laps, false);
    }

    public void race() {
        long start = System.nanoTime();
        for (int i = 0; i < num_laps; i++) {

            lap++;
            if (debug) {
                System.out.println(name + " completed Lap " + lap);
            }
        }
        time = System.nanoTime() - start;
    }

    @Override
    public void run() {
        race();
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

    public static void main(String[] args) {
        ThreadRacer r1 = new ThreadRacer ("Mario", 10, true);

        r1.start();

        System.out.println (r1.getRacerName() + " Finished in " + r1.getFinishTime() + " seconds");
    }

}

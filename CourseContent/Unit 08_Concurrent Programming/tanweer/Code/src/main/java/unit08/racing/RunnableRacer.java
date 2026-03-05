package unit08.racing;

public class RunnableRacer extends Racer implements Runnable {

    public RunnableRacer (String name, int laps, boolean debug) {
        super (name, laps, debug);
    }

    public RunnableRacer (String name, int laps) {
        super (name, laps);
    }

    @Override
    public void run() {
        race();
    }
}

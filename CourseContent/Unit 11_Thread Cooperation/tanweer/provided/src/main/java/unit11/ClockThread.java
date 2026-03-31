package unit11;

public class ClockThread implements Runnable {
    private final Clock clock;

    public ClockThread(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(clock);
            try {
                Thread.sleep(clock.getTimeBetweenTicks());
            } catch (InterruptedException e) {
                // never happen, so squash
            }
            clock.increment();
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock();
        ClockThread clockThread = new ClockThread(clock);
        Thread thread = new Thread(clockThread);
        thread.start();
    }
}

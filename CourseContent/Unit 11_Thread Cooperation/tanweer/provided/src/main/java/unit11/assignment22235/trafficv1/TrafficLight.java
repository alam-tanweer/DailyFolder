package unit11.assignment22235.trafficv1;

public class TrafficLight implements Runnable {
    public enum Color {
        RED,
        YELLOW,
        GREEN
    }

    private static final long TICK = 1000;
    private static final long PAUSE = TICK;
    private static final long GREEN = TICK * 5;
    private static final long YELLOW = TICK * 2;


    private final String description;
    private final Object lock;
    private Color color;

    public TrafficLight(String description, Object lock) {
        this.description = description;
        this.lock = lock;
        color = Color.RED;
    }

    @Override
    public void run() {
        System.out.println(this + " is " + color);
        synchronized(lock) {
            while(true) {
                try {
                    Thread.sleep(PAUSE);
                    setColor(Color.GREEN);
                    Thread.sleep(GREEN);
                    setColor(Color.YELLOW);
                    Thread.sleep(YELLOW);
                    setColor(Color.RED);
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    // squash
                }
            }
        }
    }

    public synchronized Color getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        return description;
    }

    private synchronized void setColor(Color color) {
        System.out.println(this + " changes from " + this.color 
            + " to " + color);
        this.color = color;
        notifyAll();
    }

    public static void main(String[] args) {
        Object lock = new Object();

        TrafficLight ns = new TrafficLight("The North/South light", lock);
        Thread nsThread = new Thread(ns);
        nsThread.start();

        TrafficLight ew = new TrafficLight("The East/West light", lock);
        Thread ewThread = new Thread(ew);
        ewThread.start();
    }
}

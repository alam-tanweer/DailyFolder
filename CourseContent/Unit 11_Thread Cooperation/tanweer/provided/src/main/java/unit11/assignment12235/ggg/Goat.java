package unit11.assignment12235.ggg;

public class Goat implements Runnable {
    public enum Color {
        CYAN,
        YELLOW,
        GREEN,
        ORANGE
    }

    private final Color color;
    private final Trough trough;
    private int turnipsEaten;

    public Goat(Color color, Trough trough) {
        this.color = color;
        this.trough = trough;
        this.turnipsEaten = 0;
    }

    public Color getColor() {
        return this.color;
    }

    public int getTurnipsEaten() {
        return this.turnipsEaten;
    }

    private boolean keepEating() {
        synchronized(trough) {
            return !(trough.atLimit() && trough.isEmpty());
        }
    }

    private void waitForTurnip() {
        synchronized(trough) {
            while(!trough.atLimit() && trough.isEmpty()) {
                System.out.println("The " + color 
                    + " goat is waiting for more turnips.");
                try {
                    trough.wait();
                } catch (InterruptedException e) {} // squash
            }
        }
    }

    private void tryToEat() {
        synchronized(trough) {
            if(trough.eat()) {
                this.turnipsEaten++;
                System.out.println(this + " has eaten a turnip!");
            }
        }
    }

    @Override
    public void run() {
        while(keepEating()) {
            waitForTurnip();
            tryToEat();
        }
    }

    @Override
    public String toString() {
        return "The " + color + " goat";
    }
}

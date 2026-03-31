package unit11.chevre;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A Goatsville Goat, just out looking for a good time.
 */
public class Goat implements Runnable {
    /**
     * The minimum coo;ness rating for a goat.
     */
    private static final int MIN_COOLNESS = 1;

    /**
     * The maximum coolness rating for a goat.
     */
    private static final int MAX_COOLNESS = 100;

    /**
     * The mininum stamina rating for a goat.
     */
    private static final int MIN_STAMINA = 5;

    /**
     * The maximum stamina rating for a goat.
     */
    private static final int MAX_STAMINA = 10;

    /**
     * The hottest night club in Goatsville.
     */
    private final ClubChevre club;

    /**
     * This goat's name.
     */
    private final String name;

    /**
     * This goat's coolness rating.
     */
    private final int coolness;

    /**
     * This goat's stamina.
     */
    private final int stamina;

    /**
     * Lock used for condition.
     */
    private final Lock lock;

    /**
     * Lets the goat wait to be picked.
     */
    private final Condition pickMe;

    /**
     * Creates a new goat with a random name, coolness rating, and stamina.
     * The goat is going to party at Club Chevre.
     *
     * @param club The club.
     */
    public Goat(ClubChevre club) {
        this.club = club;

        name = Utils.makeGoatName();
        coolness = Utils.getRandomNumber(MIN_COOLNESS, MAX_COOLNESS);
        stamina = Utils.getRandomNumber(MIN_STAMINA, MAX_STAMINA);
        lock = new ReentrantLock();
        pickMe = lock.newCondition();
    }

    /**
     * Returns this goat's coolness rating.
     *
     * @return The cool factor for this particular goat.
     */
    public int getCoolness() {
        return coolness;
    }

    /**
     * Returns this goat's stamina rating.
     *
     * @return The stamina for this particular goat.
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Returns this goat's name.
     *
     * @return The name of this goat.
     */
    public String getName() {
        return name;
    }

    /**
     * Notifies the goat they've been picked
     */
    public void pick() {
        try {
            lock.lock();
            pickMe.notify();
        } finally { lock.unlock(); }
    }

    /**
     * Party time.
     */
    @Override
    public void run() {
        try {
            lock.lock();

            // get into the line
            synchronized(club) {
                club.getInLine(this);
                System.out.println(name + " gets into line behind " +
                        (club.numberOfGoatsInLine() - 1) + " other goats.");
                club.notify();
            }

            // wait to be picked
            pickMe.awaitUninterruptibly();
        } finally { lock.unlock(); }

        // dance
        for(int i=0; i<stamina; i++) {
            System.out.println(name + " is dancing!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // squash
            }
        }

        synchronized(club) {
            club.stopDancing(this);
            System.out.println(name +
                    " is exhausted and heads home.");
            club.notify();
        }
    }

    @Override
    public String toString() {
        return name + "{coolness=" + coolness + ",stamina=" + stamina + "}";
    }
}
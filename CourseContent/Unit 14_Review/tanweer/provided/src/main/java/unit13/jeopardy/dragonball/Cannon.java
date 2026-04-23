package unit13.jeopardy.dragonball;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Represents a cannon that holds and fires colored fireballs at a dragon.
 * Fireballs are loaded with random {@link Color} values upon construction
 * and dispensed in FIFO order.
 */
public class Cannon {
    private final Random rng = new Random();
    private final Queue<Color> fireBalls;

    /**
     * Constructs a Cannon loaded with the specified number of randomly colored fireballs.
     *
     * @param numberOfFireBalls the number of fireballs to load into the cannon
     */
    public Cannon(int numberOfFireBalls) {
        this.fireBalls = new LinkedList<>();
        Color[] colors = Color.values();
        for (int i = 0; i < numberOfFireBalls; i++) {
            fireBalls.add(colors[rng.nextInt(colors.length)]);
        }

        System.out.println("Cannon loaded with " + fireBalls.size() + " fireballs: " + fireBalls);
    }

    /**
     * Returns whether the cannon has no remaining fireballs.
     *
     * @return {@code true} if the cannon is empty; {@code false} otherwise
     */
    public boolean isEmpty() { return fireBalls.isEmpty(); }

    /**
     * Returns the color of the next fireball without removing it from the cannon.
     *
     * @return the {@link Color} of the next fireball
     * @throws IllegalStateException if the cannon is empty
     */
    public Color peek() {
        if (isEmpty())
            throw new IllegalStateException("Canon is empty!");

        Color fireBall = fireBalls.peek();
        System.out.println("Cannon ready to fire " + fireBall + " fireball!");
        return fireBall;
    }

    /**
     * Fires and removes the next fireball from the cannon.
     *
     * @return the {@link Color} of the fired fireball
     * @throws IllegalStateException if the cannon is empty
     */
    public Color fire() {
        if (isEmpty())
            throw new IllegalStateException("Canon is empty!");

        Color fireBall = fireBalls.remove();
        System.out.println("Cannon firing " + fireBall + " fireball!");
        return fireBall;
    }
}

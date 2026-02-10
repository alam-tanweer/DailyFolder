package unit05.practicum.ssb;

import java.util.Random;

/**
 * It is reasonable to think that the student may come up with an abstract
 * fighter instead of an interface.
 */
public abstract class AbstractFighter implements Fighter {
    protected static final Random RNG = new Random();
    private String name;
    private int health;

    public AbstractFighter(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public void takeDamage(int amount) {
        System.out.println(name + " is hit for " + amount + " damage!");
        health -= amount;
        health = health > 0 ? health : 0;
    }

    @Override
    public boolean isConscious() {
        return health > 0;
    }

    @Override
    public String toString() {
        return name;
    }

}

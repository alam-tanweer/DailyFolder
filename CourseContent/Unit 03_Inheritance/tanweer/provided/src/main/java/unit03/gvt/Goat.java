package unit03.gvt;

import java.util.Random;

/**
 * A class that represents a common goat. It defines all of the state and
 * behavior that is common to goats in a game of Goats vs. Trolls.
 * 
 * @author GCCIS Faculty
 */
public abstract class Goat {
    /**
     * Used for pseudorandom number generation when needed/
     */
    protected static final Random RNG = new Random();

    private final String name;
    private final int maxHP;
    private int currentHP;

    /**
     * Creates a new goat with the specified attributes.
     * 
     * @param name The name of the new goat.
     * @param maxHP The goat's maximum hit points.
     */
    public Goat(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        currentHP = maxHP;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }


    /**
     * Implemented by subclasses to create an attack appropriate for that
     * type of goat.
     * 
     * @return The goat's next attack.
     */
    public abstract Attack attack();

    /**
     * Implemented by subclasses to handle an attack from an opponent. 
     * Different goats respond differently depending on the damage type of the
     * attack.
     * 
     * @param attack The attack that has been launched at the goat.
     */
    public abstract void takeDamage(Attack attack);
    
    /**
     * Returns true if the goat has at least 1 hit point remaining.
     * 
     * @return True if the goat has at least one remaining hit point, false
     * otherwise.
     */
    public boolean isConscious() {
        return currentHP > 0;
    }

    /**
     * Heals the goat by the specified amount. The goat cannot be overhealed,
     * i.e. the current hit points cannot exceed the maximum hit points.
     * 
     * @param amount The amount by which the goat is being healed.
     */
    public void heal(int amount) {
        currentHP += amount;
        currentHP = currentHP < maxHP ? currentHP : maxHP;
    }

    /**
     * Reduces the goat's current hit points based on the specified attack and
     * the adjustment (which is based on the goat's resistance to a particular
     * type of damage).
     * 
     * @param attack The attack launched against the goat.
     * @param adjustment The amount by which the base damage in the attack
     * should be adjusted based on the goat's resistence.
     */
    protected void takeDamage(Attack attack, double adjustment) {
        for(int hit : attack.getHits()) {
            int amount = (int)(hit * adjustment);
            currentHP -= amount;
        }
        currentHP = currentHP > 0 ? currentHP : 0;
    }
    
    @Override
    public String toString() {
        return "Goat: " + getName() + " Current HP: " + getCurrentHP();
    }

}

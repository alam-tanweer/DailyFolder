package unit03.gvt;

/**
 * Parent class that encapsulates common state and behavior
 * shared by all goats.
 */
public class Goat {

    private String name;
    private int maximumHP;
    private int currentHP;

    /**
     * Constructs a Goat with the given name and maximum HP.
     *
     * @param name the goat's name
     * @param maximumHP the goat's maximum hit points
     */
    public Goat(String name, int maximumHP) {
        this.name = name;
        this.maximumHP = maximumHP;
        this.currentHP = maximumHP;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public int getMaximumHP() {
        return maximumHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    /**
     * Heals this goat by the specified amount, not exceeding max HP.
     *
     * @param amount amount of HP to restore
     */
    public void heal(int amount) {
        currentHP += amount;
        if (currentHP > maximumHP) {
            currentHP = maximumHP;
        }
    }

    /**
     * @return true if current HP is greater than 0
     */
    public boolean isConscious() {
        return currentHP > 0;
    }

    /**
     * Stub attack method to support polymorphism.
     * Subclasses override this method.
     *
     * @return null
     */
    public Attack attack() {
        return null;
    }

    /**
     * Stub takeDamage method to support polymorphism.
     * Subclasses override this method.
     *
     * @param attack incoming attack
     */
    public void takeDamage(Attack attack) {
        // intentionally empty
    }

    /**
     * Allows subclasses to safely reduce HP.
     *
     * @param amount damage amount
     */
    protected void reduceHP(int amount) {
        currentHP -= amount;
        if (currentHP < 0) {
            currentHP = 0;
        }
    }

    @Override
    public String toString() {
        return "A goat named " + name + " with "
                + currentHP + "/" + maximumHP + " hit points!";
    }
}

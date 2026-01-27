package unit03.gvt;

/**
 * Abstract parent class for all Troll enemy types.
 * Encapsulates common state and behavior (HP, healing, consciousness).
 */
public abstract class Troll {

    private String name;
    private int maximumHP;
    private int currentHP;

    public Troll(String name, int maximumHP) {
        this.name = name;
        this.maximumHP = maximumHP;
        this.currentHP = maximumHP;
    }

    public String getName() {
        return name;
    }

    public int getMaximumHP() {
        return maximumHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void heal(int amount) {
        currentHP += amount;
        if (currentHP > maximumHP) {
            currentHP = maximumHP;
        }
    }

    public boolean isConscious() {
        return currentHP > 0;
    }

    protected void reduceHP(int amount) {
        currentHP -= amount;
        if (currentHP < 0) {
            currentHP = 0;
        }
    }

    /**
     * Regenerates a percentage of max HP (e.g., 0.03 for 3%).
     * Used by troll subclasses after taking damage.
     */
    protected void regenerate(double percentOfMax) {
        int amount = (int) (getMaximumHP() * percentOfMax);
        if (amount < 1) {
            amount = 1; // ensure regen is noticeable for small HP pools
        }
        heal(amount);
    }

    public abstract Attack attack();

    public abstract void takeDamage(Attack attack);

    @Override
    public String toString() {
        return "A troll named " + name + " with "
                + currentHP + "/" + maximumHP + " hit points!";
    }
}

package unit03.gvt;

//3.19
public abstract class Troll implements Combatant {

    private String name;
    private int maximumHP;
    private int currentHP;
    private final double regenAmount;

    /**
     * Constructs a Troll with a fixed name and maximum HP.
     * Current HP starts at maximum HP.
     *
     * @param name the troll's name (often the same as its class/type)
     * @param maximumHP the troll's maximum hit points
     */
    public Troll(String name, int maximumHP, double regenAmount) {
        this.name = name;
        this.maximumHP = maximumHP;
        this.currentHP = maximumHP;
        this.regenAmount = regenAmount;
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
     * @return true if current HP is 0 (troll is vanquished permanently)
     */
    public boolean isVanquished() {
        return currentHP <= 0;
    }

    /**
     * Reduces HP, not going below 0.
     */
    protected void reduceHP(int amount) {
        if (amount <= 0) {
            return;
        }
        currentHP -= amount;
        if (currentHP < 0) {
            currentHP = 0;
        }
    }

    /**
     * Regenerates a percentage of max HP (e.g., 0.03 for 3%).
     * Typically used at the start of each round. Does nothing if vanquished.
     */
    public void regenerate() {
        if (isVanquished()) {
            return;
        }
        int amount = (int) (maximumHP * regenAmount);

        //ensuring that it is not .5 etc
        if (amount < 1) {
            amount = 1;
        }

        currentHP += amount;

        if (currentHP > maximumHP) {
            currentHP = maximumHP;
        }
    }

    /**
     * All trolls can attack, but each troll type attacks differently.
     */
    public abstract Attack attack();

    /**
     * All trolls can take damage, but each troll type handles damage differently
     * (e.g., weakness modifiers).
     */
    public abstract void takeDamage(Attack attack);

    @Override
    public String toString() {
        return "A troll named " + name + " with "
                + currentHP + "/" + maximumHP + " hit points!";
    }
}


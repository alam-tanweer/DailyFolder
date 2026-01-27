package unit03.gvt;

/**
 * Represents a Mage goat in Goats vs. Trolls.
 */
public class Mage {

    private String name;
    private int maximumHP;
    private int currentHP;

    /**
     * Constructs a Mage with the given name.
     * Sets both maximum and current HP to 120.
     *
     * @param name the name of the mage
     */
    public Mage(String name) {
        this.name = name;
        this.maximumHP = 120;
        this.currentHP = 120;
    }

    /**
     * Returns the Mage's primary attack: Magic Missiles.
     * Hits 4 times for 9 points of magical damage each.
     *
     * @return an Attack representing Magic Missiles
     */
    public Attack attack() {
        return new Attack(
                "Magic Missiles",
                new int[]{9, 9, 9, 9},
                DamageType.MAGICAL
        );
    }

    /**
     * Applies damage from an incoming attack.
     * Magical damage is reduced by 25%.
     * Physical damage is increased by 25%.
     *
     * @param attack the attack being received
     */
    public void takeDamage(Attack attack) {
        int totalDamage = 0;

        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        // Apply damage modifiers
        if (attack.getDamageType() == DamageType.MAGICAL) {
            totalDamage *= 0.75;   // 25% reduction
        } else if (attack.getDamageType() == DamageType.PHYSICAL) {
            totalDamage *= 1.25;   // 25% increase
        }

        currentHP -= totalDamage;

        if (currentHP < 0) {
            currentHP = 0;
        }
    }

    /**
     * Heals the Mage by the specified amount,
     * without exceeding maximum HP.
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
     * Indicates whether the Mage is conscious.
     *
     * @return true if current HP is greater than 0
     */
    public boolean isConscious() {
        return currentHP > 0;
    }

    /**
     * Returns a string representation of the Mage.
     *
     * @return formatted Mage description
     */
    @Override
    public String toString() {
        return "A mage named " + name + " with "
                + currentHP + "/" + maximumHP + " hit points!";
    }

    /**
     * Main method for testing Mage combat.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Mage mage1 = new Mage("Hairy Potter");
        Mage mage2 = new Mage("Merlamb");

        mage1.takeDamage(mage2.attack());
        mage2.takeDamage(mage1.attack());

        System.out.println(mage1);
        System.out.println(mage2);
    }
}

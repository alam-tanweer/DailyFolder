package unit03.gvt;

import java.util.Arrays;

/**
 * Represents an attack in a game of Goats vs. Trolls.
 * 
 * @author GCCIS Faculty
 */
public class Attack {
    private final String name;
    private final int[] hits;
    private final DamageType type;

    /**
     * Creates a new attack with the specified attributes.
     * 
     * @param name The name of the attack.
     * @param hits The hits, representing the amount of damage.
     * @param type The damage type.
     */
    public Attack(String name, int[] hits, DamageType type) {
        this.name = name;
        this.hits = hits;
        this.type = type;
    }

    public DamageType getDamageType() {
        return type;
    }

    public int[] getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (hits for " + Arrays.toString(hits) + " points of "
            + type + " damage)";
    }
}

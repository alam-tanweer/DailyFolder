package unit03.gvt;

/**
 * Represents an attack in Goats vs. Trolls.
 * Each attack has a name, a number of hits (with damage per hit),
 * and a damage type.
 */
public class Attack {

    private final String name;
    private final int[] hits;
    private final DamageType damageType;

    /**
     * Constructs an Attack with the given name, hits, and damage type.
     *
     * @param name the name of the attack
     * @param hits an array representing damage for each hit
     * @param damageType the type of damage this attack deals
     */
    public Attack(String name, int[] hits, DamageType damageType) {
        this.name = name;
        // Defensive copy to preserve immutability
        this.hits = hits.clone();
        this.damageType = damageType;
    }

    /**
     * @return the name of the attack
     */
    public String getName() {
        return name;
    }

    /**
     * @return a copy of the hits array
     */
    public int[] getHits() {
        return hits.clone();
    }

    /**
     * @return the damage type of the attack
     */
    public DamageType getDamageType() {
        return damageType;
    }
}

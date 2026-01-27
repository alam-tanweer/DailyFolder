package unit03.assignment1.trolls;

/**
 * A class representing a mage in a game of Goats vs. Trolls.
 * 
 * @author GCCIS Faculty.
 */
public class Mage extends Goat {
    /**
     * Creates a new fighter with the specified name.
     * 
     * @param name The name of the new fighter.
     */
    public Mage(String name) {
        super(name, 100);
    }

    public Attack attack() {
        int[] hits = new int[RNG.nextInt(3, 6)];
        for (int i=0; i<hits.length; i++) {
            hits[i] = RNG.nextInt(6, 12);
        }
        return new Attack("Magic Missiles", hits, DamageType.MAGICAL);
    }

    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 0.75;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 1.25;
        }
        takeDamage(attack, adjustment);
    }
}

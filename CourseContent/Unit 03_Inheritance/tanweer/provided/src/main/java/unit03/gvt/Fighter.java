package unit03.gvt;

/**
 * A class representing a fighter in a game of Goats vs. Trolls.
 * 
 * @author GCCIS Faculty.
 */
public class Fighter extends Goat {
    /**
     * Creates a new fighter with the specified name.
     * 
     * @param name The name of the new fighter.
     */
    public Fighter(String name) {
        super(name, 150);
    }
    
    @Override
    public Attack attack() {
        int[] hits = { RNG.nextInt(15, 46) };
        return new Attack("Cleave", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        double adjustment = 1.0;
        DamageType type = attack.getDamageType();
        if(type == DamageType.MAGICAL) {
            adjustment = 1.25;
        } else if(type == DamageType.PHYSICAL) {
            adjustment = 0.75;
        }
        takeDamage(attack, adjustment);
    }
}

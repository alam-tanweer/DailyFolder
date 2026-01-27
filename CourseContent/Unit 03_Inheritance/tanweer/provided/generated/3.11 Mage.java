package unit03.gvt;

/**
 * Represents a Mage goat in Goats vs. Trolls.
 */
public class Mage extends Goat {

    /**
     * Constructs a Mage with the given name.
     * Maximum HP for all mages is always 120.
     *
     * @param name the mage's name
     */
    public Mage(String name) {
        super(name, 120);
    }

    /**
     * Returns the Mage's primary attack: Magic Missiles.
     * Hits 4 times for 9 points of magical damage each.
     *
     * @return an Attack representing Magic Missiles
     */
    @Override
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
     * @param attack the incoming attack
     */
    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;

        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        if (attack.getDamageType() == DamageType.MAGICAL) {
            totalDamage *= 0.75;
        } else if (attack.getDamageType() == DamageType.PHYSICAL) {
            totalDamage *= 1.25;
        }

        reduceHP(totalDamage);
    }

    /**
     * Main method for testing Mage behavior.
     */
    public static void main(String[] args) {
        Mage m1 = new Mage("Hairy Potter");
        Mage m2 = new Mage("Merlamb");

        System.out.println(m1);
        System.out.println(m2);

        m1.takeDamage(m2.attack());
        m2.takeDamage(m1.attack());

        System.out.println(m1);
        System.out.println(m2);
    }
}

package unit03.gvt;

//3.6
public class Fighter extends Goat {

    // private String name;
    // private int maximumHP;
    // private int currentHP;

    /**
     * Constructs a Fighter with the given name.
     * Sets both maximum and current HP to 150.
     *
     * @param name the name of the fighter
     */
    public Fighter(String name) {
        super(name,Constants.FIGHTER_HP);
        // this.name = name;
        // this.maximumHP = 150;
        // this.currentHP = 150;
    }

    /**
     * Returns the Fighter's primary attack: Cleave.
     * Hits once for 25 points of physical damage.
     *
     * @return an Attack representing Cleave
     */
    public Attack attack() {
        return new Attack(
                "Cleave",
                new int[]{25},
                DamageType.PHYSICAL
        );
    }

    /**
     * Applies damage from an incoming attack.
     * Magical damage is increased by 25%.
     * Physical damage is reduced by 25%.
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
            totalDamage *= 1.25;   // 25% increase
        } else if (attack.getDamageType() == DamageType.PHYSICAL) {
            totalDamage *= 0.75;   // 25% reduction
        }

        reduceHP(totalDamage);
        // currentHP -= totalDamage;

        // if (currentHP < 0) {
        //     currentHP = 0;
        // }
    }

    /**
     * Heals the Fighter by the specified amount,
     * without exceeding maximum HP.
     *
     * @param amount amount of HP to restore
     */
    // public void heal(int amount) {
    //     currentHP += amount;

    //     if (currentHP > maximumHP) {
    //         currentHP = maximumHP;
    //     }
    // }

    /**
     * Indicates whether the Fighter is conscious.
     *
     * @return true if current HP is greater than 0
     */
    // public boolean isConscious() {
    //     return currentHP > 0;
    // }

    /**
     * Returns a string representation of the Fighter.
     *
     * @return formatted Fighter description
     */
    // @Override
    // public String toString() {
    //     return "A fighter named " + name + " with "
    //             + currentHP + "/" + maximumHP + " hit points!";
    // }

    /**
     * Main method for testing Fighter combat.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("Brawn");
        Fighter fighter2 = new Fighter("Sir Goatsalot");

        System.out.println(fighter1);
        System.out.println(fighter2);

        fighter1.takeDamage(fighter2.attack());
        fighter2.takeDamage(fighter1.attack());

        System.out.println(fighter1);
        System.out.println(fighter2);
    }
}

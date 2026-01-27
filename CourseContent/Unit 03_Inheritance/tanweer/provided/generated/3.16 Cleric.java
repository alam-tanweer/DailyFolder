package unit03.gvt;

public class Cleric extends Goat {

    private static final int MAX_HP = 140;

    public Cleric(String name) {
        super(name, MAX_HP);
    }

    /**
     * Cleric attack: Smite
     * Hits twice for 12 points of holy damage each.
     */
    @Override
    public Attack attack() {
        return new Attack(
                "Smite",
                new int[]{12, 12},
                DamageType.HOLY
        );
    }

    /**
     * Cleric damage modifiers:
     * - Holy damage reduced by 25%
     * - Poison damage increased by 25%
     */
    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;

        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        if (attack.getDamageType() == DamageType.HOLY) {
            totalDamage = (int) (totalDamage * 0.75);
        } else if (attack.getDamageType() == DamageType.POISON) {
            totalDamage = (int) (totalDamage * 1.25);
        }

        reduceHP(totalDamage);
    }

    /**
     * Main method to test Cleric behavior.
     */
    public static void main(String[] args) {
        Cleric c1 = new Cleric("Saint Bleat");
        Cleric c2 = new Cleric("Holy Hooves");

        System.out.println(c1);
        System.out.println(c2);

        c1.takeDamage(c2.attack());
        c2.takeDamage(c1.attack());

        System.out.println(c1);
        System.out.println(c2);
    }
}

package unit03.gvt;

import java.util.Random;

public class Cleric extends Goat {

    private static final int MAX_HP = 125;
    private static final Random rand = new Random();

    public Cleric(String name) {
        super(name, MAX_HP);
    }

    @Override
    public Attack attack() {
        int damage = rand.nextInt(11) + 15; // 15–25 damage
        return new Attack(
                "Bell, Book, & Candle",
                new int[]{damage},
                DamageType.HOLY
        );
    }

    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;
        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        reduceHP(totalDamage);
    }

    /**
     * Cleric heals for 25% of holy damage dealt.
     * This is handled after attacking in the arena.
     */
    public void applyHolyHealing(Attack attack) {
        if (attack.getDamageType() == DamageType.HOLY) {
            int totalDamage = 0;
            for (int hit : attack.getHits()) {
                totalDamage += hit;
            }
            heal(totalDamage / 4);
        }
    }

    public static void main(String[] args) {
        Cleric c1 = new Cleric("Saint Bleat");
        Cleric c2 = new Cleric("Holy Hooves");

        System.out.println(c1);
        System.out.println(c2);

        Attack atk1 = c1.attack();
        Attack atk2 = c2.attack();

        c2.takeDamage(atk1);
        c1.applyHolyHealing(atk1);

        c1.takeDamage(atk2);
        c2.applyHolyHealing(atk2);

        System.out.println(c1);
        System.out.println(c2);
    }
}

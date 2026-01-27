package unit03.gvt;

import java.util.Random;

public class Thief extends Goat {

    private static final int MAX_HP = 125;
    private static final Random rand = new Random();

    public Thief(String name) {
        super(name, MAX_HP);
    }

    @Override
    public Attack attack() {
        int numberOfHits = rand.nextInt(3) + 1; // 1–3 hits
        int[] hits = new int[numberOfHits];

        for (int i = 0; i < numberOfHits; i++) {
            int damage = rand.nextInt(11) + 10; // 10–20 damage

            // 25% crit chance (double damage)
            if (rand.nextDouble() < 0.25) {
                damage *= 2;
            }

            hits[i] = damage;
        }

        return new Attack("Stabbity-Stab", hits, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;
        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        // Special: -25% poison damage taken
        if (attack.getDamageType() == DamageType.POISON) {
            totalDamage = (int) (totalDamage * 0.75);
        }

        reduceHP(totalDamage);
    }

    public static void main(String[] args) {
        Thief t1 = new Thief("Sneaky Hoof");
        Thief t2 = new Thief("Shadow Bleat");

        System.out.println(t1);
        System.out.println(t2);

        t1.takeDamage(t2.attack());
        t2.takeDamage(t1.attack());

        System.out.println(t1);
        System.out.println(t2);
    }
}

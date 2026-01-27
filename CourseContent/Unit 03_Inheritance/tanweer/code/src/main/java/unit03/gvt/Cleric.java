package unit03.gvt;

import java.util.Random;

public class Cleric extends Goat {

    private static final Random rand = new Random();

    public Cleric(String name) {
        super(name, Constants.CLERIC_HP);
    }

    @Override
    public Attack attack() {
        int damage = rand.nextInt(15,26); // 15–25 damage
        System.out.println("Damage is " + damage);
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

        System.out.println("Total Damage: " + totalDamage);
        if (attack.getDamageType() == DamageType.HOLY) { 
            heal(totalDamage / 4);
        } else {
            reduceHP(totalDamage);
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

        c1.takeDamage(atk2);

        System.out.println(c1);
        System.out.println(c2);
    }    
}

package unit03.gvt;

public class Mage extends Goat {

    public Mage(String name) {
        super(name, 120);
    }

    @Override
    public Attack attack() {
        return new Attack("Magic Missiles", new int[]{9, 9, 9, 9}, DamageType.MAGICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;
        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        // Mage modifiers:
        // magical damage reduced by 25%, physical damage increased by 25%
        if (attack.getDamageType() == DamageType.MAGICAL) {
            totalDamage = (int) (totalDamage * 0.75);
        } else if (attack.getDamageType() == DamageType.PHYSICAL) {
            totalDamage = (int) (totalDamage * 1.25);
        }

        reduceHP(totalDamage);
    }

}

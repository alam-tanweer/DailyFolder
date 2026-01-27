package unit03.activities;

public class Mage extends Goat {

    public Mage(String name) {
        super(name, 100);
    }

    public Attack attack() {
        int[] hits = {9, 9, 9, 9};
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

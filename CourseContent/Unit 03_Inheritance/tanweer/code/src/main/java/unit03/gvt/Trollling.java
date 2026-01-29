package unit03.gvt;

public class Trollling extends Troll {

    private static final int MAX_HP = 38;
    private static final double REGEN_AMOUNT = 0.03;

    public Trollling(String name) {
        super(name, MAX_HP, REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        return new Attack("U Mad", new int[]{25}, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;
        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        // Takes +25% magical damage
        if (attack.getDamageType() == DamageType.MAGICAL) {
            totalDamage = (int) (totalDamage * 1.25);
        }

        reduceHP(totalDamage);
    }
}

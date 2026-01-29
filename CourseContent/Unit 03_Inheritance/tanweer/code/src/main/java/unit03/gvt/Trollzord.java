package unit03.gvt;

public class Trollzord extends Troll {

    private static final int MAX_HP = 64;
    private static final double REGEN_AMOUNT = 0.05;

    public Trollzord(String name) {
        super(name, MAX_HP, REGEN_AMOUNT);
    }

    @Override
    public Attack attack() {
        return new Attack("Flame War", new int[]{25}, DamageType.MAGICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;
        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        // Takes +25% holy damage
        if (attack.getDamageType() == DamageType.HOLY) {
            totalDamage = (int) (totalDamage * 1.25);
        }

        reduceHP(totalDamage);
    }
}

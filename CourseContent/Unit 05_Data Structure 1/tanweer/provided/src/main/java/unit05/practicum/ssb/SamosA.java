package unit05.practicum.ssb;

// either or
public class SamosA extends AbstractFighter {// implements Fighter {
    private static final String NAME = "Samos A.";
    private static final int ARM_CANNON_DAMAGE = 40;
    private static final double ARM_CANNON_CHANCE = 0.75;
    private static final int MISSILE_DAMAGE = 75;

    public SamosA() {
        super(NAME, 200);
    }

    @Override
    public int getDamage() {
        if (RNG.nextDouble() < ARM_CANNON_CHANCE) {
            System.out.println(NAME + " fires her arm cannon for "
                    + ARM_CANNON_DAMAGE + " damage!");
            return ARM_CANNON_DAMAGE;
        } else {
            System.out.println(NAME + "fires her missiles for "
                    + MISSILE_DAMAGE + " damage!");
            return MISSILE_DAMAGE;
        }
    }
}

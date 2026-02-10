package unit05.practicum.ssb;

// either or
public class Lonk extends AbstractFighter {// implements Fighter {
    private static final String NAME = "Lonk";
    private static final int SWORD_DAMAGE = 45;
    private static final double BLOCK_CHANCE = 0.5;

    public Lonk() {
        super(NAME, 150);
    }

    @Override
    public void takeDamage(int amount) {
        if (RNG.nextDouble() < BLOCK_CHANCE) {
            amount = amount / 2;
            System.out.println(NAME + " blocks with their shield! Damage is "
                    + "reduced to " + amount + "!");
        }
        super.takeDamage(amount);
    }

    @Override
    public int getDamage() {
        System.out.println(NAME + " attacks with their sword for "
                + SWORD_DAMAGE + " damge!");
        return SWORD_DAMAGE;
    }

}

package unit05.practicum.ssb;

// either or
public class Manio extends AbstractFighter {// implements Fighter {
    private static final String NAME = "Manio";
    private static final double DODGE_CHANCE = 0.5;
    private static final int MIN_DAMAGE = 25;
    private static final int MAX_DAMAGE = 50;

    public Manio() {
        super("Manio", 100);
    }

    @Override
    public void takeDamage(int amount) {
        if (RNG.nextDouble() < DODGE_CHANCE) {
            super.takeDamage(amount);
        } else {
            System.out.println(NAME + " dodges the incoming attack!");
        }

    }

    @Override
    public int getDamage() {
        int bound = MAX_DAMAGE - MIN_DAMAGE + 1;
        int amount = RNG.nextInt(bound) + MIN_DAMAGE;
        System.out.println(NAME + " executes a Jump Attack for " + amount +
                " damage!");
        return amount;
    }
}

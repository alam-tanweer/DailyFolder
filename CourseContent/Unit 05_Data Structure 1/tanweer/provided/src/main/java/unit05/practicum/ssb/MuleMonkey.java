package unit05.practicum.ssb;

// either or
public class MuleMonkey extends AbstractFighter {// implements Fighter {
    private static final String NAME = "Mule Monkey";
    private static final double BASH_CHANCE = 0.75;
    private static final int BASH_DAMAGE = 75;

    public MuleMonkey() {
        super(NAME, 200);
    }

    @Override
    public int getDamage() {
        if (RNG.nextDouble() < BASH_CHANCE) {
            System.out.println(NAME + " bashes for " + BASH_DAMAGE + "!");
            return BASH_DAMAGE;
        } else {
            System.out.println(NAME + " goes wild and misses!");
            return 0;
        }
    }

}

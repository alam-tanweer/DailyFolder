package unit03.gvt;

public class Trollling extends Troll {

    private static final int MAX_HP = 38;

    public Trollling(String name) {
        super(name, MAX_HP);
    }

    @Override
    public Attack attack() {
        return new Attack("U Mad?", new int[]{15}, DamageType.PHYSICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        int totalDamage = 0;
        for (int hit : attack.getHits()) {
            totalDamage += hit;
        }

        // Special: Takes +25% Magical Damage
        if (attack.getDamageType() == DamageType.MAGICAL) {
            totalDamage = (int) (totalDamage * 1.25);
        }

        reduceHP(totalDamage);

        // Special: Regenerates 3% (only if still conscious)
        if (isConscious()) {
            regenerate(0.03);
        }
    }

    public static void main(String[] args) {
        Trollling t1 = new Trollling("Trolly McTrollface");
        Trollling t2 = new Trollling("Green Gremlin");

        System.out.println(t1);
        System.out.println(t2);

        t1.takeDamage(t2.attack());
        t2.takeDamage(t1.attack());

        System.out.println(t1);
        System.out.println(t2);
    }
}

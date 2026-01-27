package unit03.gvt;

public class Trollzord extends Troll {

    private static final int MAX_HP = 64;

    public Trollzord(String name) {
        super(name, MAX_HP);
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

        // Special: Takes +25% Holy Damage
        if (attack.getDamageType() == DamageType.HOLY) {
            totalDamage = (int) (totalDamage * 1.25);
        }

        reduceHP(totalDamage);

        // Special: Regenerates 5% (only if still conscious)
        if (isConscious()) {
            regenerate(0.05);
        }
    }

    public static void main(String[] args) {
        Trollzord z1 = new Trollzord("Zord the Loud");
        Trollzord z2 = new Trollzord("Flame Poster");

        System.out.println(z1);
        System.out.println(z2);

        z1.takeDamage(z2.attack());
        z2.takeDamage(z1.attack());

        System.out.println(z1);
        System.out.println(z2);
    }
}

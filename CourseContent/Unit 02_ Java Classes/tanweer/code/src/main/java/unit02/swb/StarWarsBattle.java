package unit02.swb;

public class StarWarsBattle {

    public static final String X_WING = "X-Wing";
    public static final String TIE_FIGHTER = "TIE Fighter";
    public static final String TAIM_AND_BAK = "Taim & Bak KX9 Laser Cannon";
    public static final String L_S1 = "L-s1 Laser Cannon";

    public static void main(String[] args) {

        // 2.2
        // Weapon weapon = new Weapon();
        // System.out.println(weapon.name + " - " + weapon.damageAmount);

        // 2.4
        // Weapon weapon = new Weapon("Tank", 12, 2, "HEAVY");
        // 2.9
        Weapon weapon = new Weapon("Tank", 12, 2, DamageType.HEAVY);

        // System.out.println(weapon.name + " - " + weapon.damageAmount);
        // 2.9
        System.out.println(weapon.getName() + " - " + weapon.getDamageAmount());

        Ship ship = new Ship("XXX", 10, 100, 20, 10);

        // 2.12
        Weapon weapon1 = new Weapon("Tank", 12, 2, DamageType.HEAVY);
        Weapon weapon2 = new Weapon("fighter", 12, 2, DamageType.HEAVY);
        Weapon weapon3 = new Weapon("Gun", 10, 2, DamageType.ION);
        System.out.println("1 and 2 : " + (weapon1.equals(weapon2)));
        System.out.println("2 and 3 : " + (weapon1.equals(weapon3)));

    }
}

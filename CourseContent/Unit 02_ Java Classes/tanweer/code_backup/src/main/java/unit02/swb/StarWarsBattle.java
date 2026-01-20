package unit02.swb;

import java.util.Arrays;

public class StarWarsBattle {

    public static final String X_WING = "X-Wing";
    public static final String TIE_FIGHTER = "TIE Fighter";
    public static final String TAIM_AND_BAK = "Taim & Bak KX9 Laser Cannon";
    public static final String L_S1 = "L-s1 Laser Cannon";

    public static void main(String[] args) {
        // At this time Weapon constructor is overwritten
        // Weapon weapon = new Weapon();
        Weapon weapon = new Weapon("Tank", 12, 2, DamageType.HEAVY);
        Ship ship = new Ship("XXX", 10, 100, 20, 10);
        System.out.println(weapon);

        Weapon weapon1 = new Weapon("Tank", 12, 2, DamageType.HEAVY);
        System.out.println(weapon == weapon1);
        System.out.println(weapon.equals(weapon1));
        System.out.println(Arrays.toString(DamageType.values()));
    }   
}

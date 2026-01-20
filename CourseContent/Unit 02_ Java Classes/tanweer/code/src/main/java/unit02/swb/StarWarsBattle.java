package unit02.swb;

public class StarWarsBattle {

    public static void main(String[] args) {
        //2.2
        // Weapon weapon  = new Weapon();
        // System.out.println(weapon.name + " - " + weapon.damageAmount);

        //2.4
        // Weapon weapon = new Weapon("Tank", 12, 2, "HEAVY");
        //2.9
        Weapon weapon = new Weapon("Tank", 12, 2, DamageType.HEAVY);

        //System.out.println(weapon.name + " - " + weapon.damageAmount);
        //2.9
        System.out.println(weapon.getName() + " - " + weapon.getDamageAmount());

        Ship ship = new Ship("XXX", 10, 100, 20, 10);

    }
}

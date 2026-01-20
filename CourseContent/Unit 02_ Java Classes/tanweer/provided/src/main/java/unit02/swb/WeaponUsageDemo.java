package unit02.swb;

public class WeaponUsageDemo {
    public static void main(String[] args) {
        Weapon w1 = new Weapon();
        Weapon w2 = new Weapon("Blaster", 50, 3, DamageType.ION);
        Weapon w3 = new Weapon("Blaster", 50, 3, DamageType.ION);
        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w3);
        System.out.println(w2.equals(w3));
        System.out.println(w2 == w3);
    }
}

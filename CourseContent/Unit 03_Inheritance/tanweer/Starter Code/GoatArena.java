package unit03.gvt;

public class GoatArena {

    public static void battle(Mage goat1, Fighter goat2) {
        while (goat1.isConscious() && goat2.isConscious()) {
            goat2.takeDamage(goat1.attack());
            if (!goat2.isConscious()) break;

            goat1.takeDamage(goat2.attack());
        }

        System.out.println(goat1);
        System.out.println(goat2);
    }

    public static void main(String[] args) {
        Mage m1 = new Mage("Hairy Potter");
        Mage m2 = new Mage("Merlamb");

        Fighter f1 = new Fighter("Brawn");
        Fighter f2 = new Fighter("Sir Goatsalot");

        battle(m1,f1);
    }    
}

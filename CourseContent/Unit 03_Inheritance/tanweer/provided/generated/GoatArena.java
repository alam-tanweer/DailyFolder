package unit03.gvt;

public class GoatArena {

    // Existing battle method (example: mage vs fighter)
    public static void battle(Mage goat1, Fighter goat2) {
        while (goat1.isConscious() && goat2.isConscious()) {
            goat2.takeDamage(goat1.attack());
            if (!goat2.isConscious()) break;

            goat1.takeDamage(goat2.attack());
        }

        System.out.println(goat1);
        System.out.println(goat2);
    }

    // NEW: Overload #1 — mage vs mage
    public static void battle(Mage goat1, Mage goat2) {
        while (goat1.isConscious() && goat2.isConscious()) {
            goat2.takeDamage(goat1.attack());
            if (!goat2.isConscious()) break;

            goat1.takeDamage(goat2.attack());
        }

        System.out.println(goat1);
        System.out.println(goat2);
    }

    // NEW: Overload #2 — fighter vs fighter
    public static void battle(Fighter goat1, Fighter goat2) {
        while (goat1.isConscious() && goat2.isConscious()) {
            goat2.takeDamage(goat1.attack());
            if (!goat2.isConscious()) break;

            goat1.takeDamage(goat2.attack());
        }

        System.out.println(goat1);
        System.out.println(goat2);
    }

    public static void main(String[] args) {
        // Call the NEW mage vs mage battle
        Mage m1 = new Mage("Hairy Potter");
        Mage m2 = new Mage("Merlamb");
        battle(m1, m2);

        // Call the NEW fighter vs fighter battle
        Fighter f1 = new Fighter("Brawn");
        Fighter f2 = new Fighter("Sir Goatsalot");
        battle(f1, f2);
    }
}

package unit03.gvt;

public class GoatArena {

    /**
     * Runs a battle between any two Goats.
     * Polymorphism ensures the correct attack and damage
     * behavior is used at runtime.
     *
     * @param goat1 first goat
     * @param goat2 second goat
     */
    public static void battle(Goat goat1, Goat goat2) {

        while (goat1.isConscious() && goat2.isConscious()) {

            goat2.takeDamage(goat1.attack());
            if (!goat2.isConscious()) {
                break;
            }

            goat1.takeDamage(goat2.attack());
        }

        System.out.println(goat1);
        System.out.println(goat2);
    }

    public static void main(String[] args) {

        // Mage vs Mage
        Goat mage1 = new Mage("Hairy Potter");
        Goat mage2 = new Mage("Merlamb");
        battle(mage1, mage2);

        // Fighter vs Fighter
        Goat fighter1 = new Fighter("Brawn");
        Goat fighter2 = new Fighter("Sir Goatsalot");
        battle(fighter1, fighter2);

        // Mage vs Fighter
        Goat mage3 = new Mage("Gandalf");
        Goat fighter3 = new Fighter("Ironhoof");
        battle(mage3, fighter3);
    }
}

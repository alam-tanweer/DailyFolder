package unit03.gvt;

public class GoatArena {

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
        System.out.println();
    }

    public static void main(String[] args) {

        // Create one of each type
        Goat plain = new Goat("Plain Goat", 100);
        Goat mage = new Mage("Hairy Potter");
        Goat fighter = new Fighter("Sir Goatsalot");
        Goat cleric = new Cleric("Saint Bleat");

        // Try many combinations
        battle(mage, fighter);     // Mage vs Fighter
        battle(fighter, mage);     // Fighter vs Mage

        battle(mage, mage);        // Mage vs Mage
        battle(fighter, fighter);  // Fighter vs Fighter
        battle(cleric, cleric);    // Cleric vs Cleric

        battle(cleric, mage);      // Cleric vs Mage
        battle(mage, cleric);      // Mage vs Cleric

        battle(cleric, fighter);   // Cleric vs Fighter
        battle(fighter, cleric);   // Fighter vs Cleric

        battle(plain, mage);       // Plain Goat vs Mage
        battle(mage, plain);       //

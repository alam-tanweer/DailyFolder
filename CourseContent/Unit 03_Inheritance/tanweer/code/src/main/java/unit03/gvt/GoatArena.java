package unit03.gvt;

public class GoatArena {

    public static void battle(Combatant c1, Combatant c2) {

        System.out.println("⚔️  Battle begins: " + c1 + " VS " + c2);

        while (isAlive(c1) && isAlive(c2)) {

            // Start-of-round regeneration for trolls (if applicable)
            if (c1 instanceof Troll) {
                ((Troll) c1).regenerate();
            }
            if (c2 instanceof Troll) {
                ((Troll) c2).regenerate();
            }

            // c1 attacks c2
            c2.takeDamage(c1.attack());
            Attack a1 = c1.attack();

            if (!isAlive(c2)) {
                break;
            }

            // c2 attacks c1
            c1.takeDamage(c2.attack());
        }

        // Print final states
        System.out.println("Final status:");
        System.out.println(c1);
        System.out.println(c2);

        // Declare winner
        if (isAlive(c1) && !isAlive(c2)) {
            System.out.println("Winner: " + c1.getName());
        } else if (isAlive(c2) && !isAlive(c1)) {
            System.out.println("Winner: " + c2.getName());
        } else {
            System.out.println("Result: Draw");
        }

        System.out.println();
    }

    private static boolean isAlive(Combatant c) {
        if (c instanceof Goat) {
            return ((Goat) c).isConscious();
        }
        if (c instanceof Troll) {
            return !((Troll) c).isVanquished();
        }
        return false;
    }

    // //3.14
    // public static void battle(Goat goat1, Goat goat2) {
    // while (goat1.isConscious() && goat2.isConscious()) {
    // goat2.takeDamage(goat1.attack());
    // if (!goat2.isConscious()) break;

    // goat1.takeDamage(goat2.attack());
    // }

    // System.out.println(goat1);
    // System.out.println(goat2);
    // }

    // 3.7
    // Existing battle method (example: mage vs fighter)
    // public static void battle(Mage goat1, Fighter goat2) {
    // while (goat1.isConscious() && goat2.isConscious()) {
    // goat2.takeDamage(goat1.attack());
    // if (!goat2.isConscious()) break;

    // goat1.takeDamage(goat2.attack());
    // }

    // System.out.println(goat1);
    // System.out.println(goat2);
    // }

    // 3.8
    // public static void battle(Mage goat1, Mage goat2) {
    // while (goat1.isConscious() && goat2.isConscious()) {
    // goat2.takeDamage(goat1.attack());
    // if (!goat2.isConscious()) break;

    // goat1.takeDamage(goat2.attack());
    // }

    // System.out.println(goat1);
    // System.out.println(goat2);
    // }

    // 3.8
    // public static void battle(Fighter goat1, Fighter goat2) {
    // while (goat1.isConscious() && goat2.isConscious()) {
    // goat2.takeDamage(goat1.attack());
    // if (!goat2.isConscious()) break;

    // goat1.takeDamage(goat2.attack());
    // }

    // System.out.println(goat1);
    // System.out.println(goat2);
    // }

    public static void main(String[] args) {
        // Call the NEW mage vs mage battle
        Mage m1 = new Mage("Hairy Potter");
        Mage m2 = new Mage("Merlamb");

        // Call the NEW fighter vs fighter battle
        Fighter f1 = new Fighter("Brawn");
        Fighter f2 = new Fighter("Sir Goatsalot");
        Cleric c1 = new Cleric("Saint Bleat");

        // Troll
        Trollling trollling = new Trollling("Dark Vador");
        Trollzord trollzord = new Trollzord("Bad Guy");

        // 3.7
        battle(f1, m1);
        battle(f2, trollling);
        battle(m1, trollzord);
    }
}

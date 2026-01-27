package unit03.gvt;

public class GoatArena {

    //3.14
    public static void battle(Goat goat1, Goat goat2) {
        while (goat1.isConscious() && goat2.isConscious()) {
            goat2.takeDamage(goat1.attack());
            if (!goat2.isConscious()) break;

            goat1.takeDamage(goat2.attack());
        }

        System.out.println(goat1);
        System.out.println(goat2);
    }

    //3.7
    // Existing battle method (example: mage vs fighter)
    // public static void battle(Mage goat1, Fighter goat2) {
    //     while (goat1.isConscious() && goat2.isConscious()) {
    //         goat2.takeDamage(goat1.attack());
    //         if (!goat2.isConscious()) break;

    //         goat1.takeDamage(goat2.attack());
    //     }

    //     System.out.println(goat1);
    //     System.out.println(goat2);
    // }

    //3.8
    // public static void battle(Mage goat1, Mage goat2) {
    //     while (goat1.isConscious() && goat2.isConscious()) {
    //         goat2.takeDamage(goat1.attack());
    //         if (!goat2.isConscious()) break;

    //         goat1.takeDamage(goat2.attack());
    //     }

    //     System.out.println(goat1);
    //     System.out.println(goat2);
    // } 

    //3.8
    // public static void battle(Fighter goat1, Fighter goat2) {
    //     while (goat1.isConscious() && goat2.isConscious()) {
    //         goat2.takeDamage(goat1.attack());
    //         if (!goat2.isConscious()) break;

    //         goat1.takeDamage(goat2.attack());
    //     }

    //     System.out.println(goat1);
    //     System.out.println(goat2);
    // }


    public static void main(String[] args) {
        // Call the NEW mage vs mage battle
        Mage m1 = new Mage("Hairy Potter");
        Mage m2 = new Mage("Merlamb");
        // battle(m1, m2);

        // Call the NEW fighter vs fighter battle
        Fighter f1 = new Fighter("Brawn");
        Fighter f2 = new Fighter("Sir Goatsalot");
        // battle(f1, f2);

        Cleric c1 = new Cleric("Saint Bleat");
        // Goat gt = new Goat("Simple Goat", 123);

        //3.7
        // battle(f1,m1);
        // battle(f2, gt);
    }    
}

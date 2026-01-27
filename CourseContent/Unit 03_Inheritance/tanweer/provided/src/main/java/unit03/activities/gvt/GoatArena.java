package unit03.activities;

public class GoatArena {
    public static void battle(Goat goat1, Goat goat2) {
        System.out.println(goat1.getName() + " and " + goat2.getName() + 
            " enter the arena!");
        int round = 1;

        while(goat1.isConscious() && goat2.isConscious()) {
            System.out.println("ROUND " + round + "! FIGHT!");
            Attack attack1 = goat1.attack();
            System.out.println(goat1.getName() 
                + " attacks with " + attack1 + "!" );
            goat2.takeDamage(attack1);

            Attack attack2 = goat2.attack();
            System.out.println(goat2.getName() 
                + " attacks with " + attack2 + "!");
            goat1.takeDamage(attack2);

            System.out.println("End of round " + round + ": ");
            System.out.println("  " + goat1);
            System.out.println("  " + goat2);
        }

        if(goat1.isConscious()) {
            System.out.println(goat1.getName() + " wins!");
        } else if(goat2.isConscious()) {
            System.out.println(goat2.getName() + " wins!");
        } else {
            System.out.println("The fight ends in a draw!");
        }
    }

    // duplicate above method with Mage, Mage and Fighter, Fighter

    public static void main(String[] args) {
        Mage mage = new Mage("Hairy Potter");
        Fighter fighter = new Fighter("Goatnan");
        battle(mage, fighter);
    }
}

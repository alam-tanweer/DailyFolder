package unit03.assignment1.trolls;

import java.util.Arrays;

/**
 * An arena that allows characters in a game of Goats vs. Trolls to battle
 * each other in a simulation.
 * 
 * @author GCCIS Faculty
 */
public class GoatArena {
    /**
     * Battles two goats of any type against eachother.
     * 
     * @param goat1 The first goat.
     * @param goat2 The second goat.
     */
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

    public static final void goatsVsTrolls(Goat[] goats, Troll[] trolls) {
        System.out.println("Two teams enter the arena...");
        System.out.println("Goats: " + Arrays.toString(goats));
        System.out.println("Trolls: " + Arrays.toString(trolls));
        System.out.println();
        int goatIndex = 0;
        int trollIndex = 0;

        int round = 1;

        while(goatIndex < goats.length && trollIndex < trolls.length) {
            System.out.println("ROUND " + round++ + "! FIGHT!");
            Goat goat = goats[goatIndex];
            Troll troll = trolls[trollIndex];

            System.out.println(goat + " vs. " + troll);

            Attack goatAttack = goat.attack();
            System.out.println(goat.getName() + " attacks with " + goatAttack);
            troll.takeDamage(goatAttack);

            Attack trollAttack = troll.attack();
            System.out.println(troll.getName() + " attacks with " 
                + trollAttack);
            goat.takeDamage(trollAttack);

            if(!goat.isConscious()) {
                goatIndex++;
            }
            if(troll.isVanquished()) {
                trollIndex++;
            }
            System.out.println("Goats: " + Arrays.toString(goats));
            System.out.println("Trolls: " + Arrays.toString(trolls));
            System.out.println();
        }

        if(goatIndex < goats.length) {
            System.out.println("The heroic goats are victorious!");
        } else if(trollIndex < trolls.length) {
            System.out.println("The evil trolls are victorious.");
        } else {
            System.out.println("Both teams wiped each other out. It's a draw.");
        }
    }

    // duplicate above method with Mage, Mage and Fighter, Fighter

    public static void main(String[] args) {
        Goat[] goats = {
            new Mage("Hairy Potter"),
            new Fighter("Goatnan"),
            new Mage("Hermione Grazer"),
            new Fighter("Mike Goatson")
        };

        Troll[] trolls = {
            new Trolling(),
            new Trolling(),
            new Trolling(),
            new Trolling(),
            new Trollzord(),
            new Trollzord(),
            new Trolling(),
            new Trolling(),
            new Trolling(),
            new Trollzord(),
            new Trollzord()
        };

        goatsVsTrolls(goats, trolls);
    }
}

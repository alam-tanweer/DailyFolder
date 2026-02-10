package unit05.practicum.ssb;

public class Arena {
    public static void battle(Fighter one, Fighter two) {
        while (one.isConscious() && two.isConscious()) {
            int oneAmount = one.getDamage();
            two.takeDamage(oneAmount);
            int twoAmount = two.getDamage();
            one.takeDamage(twoAmount);

        }

        if (one.isConscious()) {
            System.out.println(two + " is unconscious! " + one + " wins!");
        } else if (two.isConscious()) {
            System.out.println(one + " is unconscious! " + two + " wins!");
        } else {
            System.out.println(one + " and " + two + " are both out! "
                    + "It's a tie!");
        }
    }

    public static void main(String[] args) {
        Fighter one = new Manio();
        Fighter two = new SamosA();

        battle(one, two);

        System.out.println("\n\n");

        one = new Lonk();
        two = new MuleMonkey();
        battle(one, two);
    }
}

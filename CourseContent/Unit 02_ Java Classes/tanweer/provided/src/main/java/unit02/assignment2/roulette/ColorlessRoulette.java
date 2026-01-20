package unit02.assignment2.roulette;

import java.util.Random;
import java.util.Scanner;

public class ColorlessRoulette {
    private static final int FIRST_NUMBER = 0;
    private static final int TOTAL_NUMBERS = 37;
    private static final int NUMBER_PAYOUT = TOTAL_NUMBERS - 1;

    private Bet[] bets;
    private int ballLocation;

    public ColorlessRoulette () {
        bets = null;
        ballLocation = FIRST_NUMBER;
    }

    public void placeBet() {
        Scanner in = new Scanner(System.in);
        System.out.print ("Enter your bets ($ #, $ #, ...): ");
        String bets = in.nextLine();
        String[] tokens = bets.split (", ");
        this.bets = new Bet[tokens.length];
        int index = 0;
        for (String token : tokens) {
            String[] parts = token.split (" ");
            int amount = Integer.parseInt (parts[0]);
            int number = Integer.parseInt (parts[1]);
            this.bets[index] = new Bet (amount, number);
            index++;
        }
        in.close();
    }

    public void spin () {
        Random random = new Random ();
        System.out.println ("The wheel spins ...");
        ballLocation = random.nextInt (TOTAL_NUMBERS);
        System.out.println ("It lands on " + ballLocation + "!");
    }

    public int payout () {
        int winnings = 0;
        for (Bet bet: bets) {
            if (bet.getNumber () == ballLocation) {
                winnings += bet.getAmount () * NUMBER_PAYOUT;
            }
        }
        return winnings;
    }

    public static void main(String[] args) {
        SimpleRoulette table = new SimpleRoulette ();
        table.placeBet ();
        table.spin ();
        int winnings = table.payout ();
        System.out.println ("You won $" + winnings + "!");
    }
}

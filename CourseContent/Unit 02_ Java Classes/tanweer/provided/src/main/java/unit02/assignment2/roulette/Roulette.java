package unit02.assignment2.roulette;

import java.util.Random;
import java.util.Scanner;

public class Roulette {
    private static final int FIRST_NUMBER = 0;
    private static final int TOTAL_NUMBERS = 37;
    private static final int SEPERATION = 26;
    private static final int COLOR_PAYOUT = 2;
    private static final int NUMBER_PAYOUT = TOTAL_NUMBERS - 1;

    private Bet[] bets;
    private int numberOfBets;
    private Location[] wheel;
    private int ballLocation;

    public Roulette () {
        bets = new Bet[4];
        numberOfBets = 0;
        ballLocation = FIRST_NUMBER;
        int number = FIRST_NUMBER;
        wheel = new Location [TOTAL_NUMBERS];
        wheel [0] = new Location (number, Color.GREEN);
        Color color = Color.RED;
        for (int index = 1; index < TOTAL_NUMBERS; index++) {
            number = (number + SEPERATION) % TOTAL_NUMBERS;
            wheel [index] = new Location (number, color);
            if (color == Color.RED) {
                color = Color.BLACK;
            }
            else {
                color = Color.RED;
            }
        }
    }

    public void placeBet(Bet bet) {
        bets[numberOfBets++] = bet;
    }

    public int spin () {
        Random random = new Random ();
        // System.out.println ("The wheel spins ...");
        ballLocation = random.nextInt (TOTAL_NUMBERS);
        Location stopped = wheel [ballLocation];
        // System.out.println ("It lands on " + stopped.getNumber() + " " + stopped.getColor() + "!");
        return stopped.getNumber();
    }

    public int payout () {
        int winnings = 0;
        Location winner = wheel [ballLocation];
        for (int i=0; i<numberOfBets; i++) {
            Bet bet = bets[i];
            if (bet.isNumberBet()) {
                if (bet.getNumber () == winner.getNumber ()) {
                    winnings += bet.getAmount () * NUMBER_PAYOUT;
                }
            }
            else {
                if (bet.getColor () == winner.getColor ()) {
                    winnings += bet.getAmount () * COLOR_PAYOUT;
                }
            }
        }
        return winnings;
    }

    public static void main(String[] args) {
        Roulette table = new Roulette ();

        Scanner in = new Scanner(System.in);
        System.out.print ("Enter your bets ($ #/R/B, $ #/R/B, ...): ");
        String bets = in.nextLine();
        String[] tokens = bets.split (", ");
        for (String token : tokens) {
            String[] parts = token.split (" ");
            int amount = Integer.parseInt (parts[0]);
            try {
                int number = Integer.parseInt (parts[1]);
                Bet bet = new Bet (amount, number);
                table.placeBet(bet);
            } catch (NumberFormatException nfe) {
                Color color = null;
                if (parts [1].toUpperCase().equals ("R"))
                    color = Color.RED;
                else
                    color = Color.BLACK;
                Bet bet = new Bet (amount, color);
                table.placeBet(bet);
            }
        }
        in.close();

        System.out.println ("The wheel spins ...");
        int location = table.spin ();
        System.out.println ("It lands on " + location + "!");
        int winnings = table.payout ();
        System.out.println ("You won $" + winnings + "!");
    }
}

package unit02.assignment2.roulette;

import java.util.Scanner;

public class Player {
    private String name;
    private int winnings;
    private Bet[] bets;


    public Player (String name, int winnings) {
        this.name = name;
        this.winnings = winnings;
    }

    public String getName() {
        return name;
    }

    public int getWinnings() {
        return winnings;
    }

    public void placeBet () {
        Scanner in = new Scanner (System.in);
        System.out.println ("Enter your bets ($ #/R/B, $ #/R/B, ...): ");
        String bets = in.nextLine ();
        String[] tokens = bets.split (",");
        this.bets = new Bet[tokens.length];
        int index = 0;
        for (String token: tokens) {
            String[] parts = token.split (" ");
            int amount = Integer.parseInt (parts[0]);
            try {
                int number = Integer.parseInt (parts[1]);
                this.bets [index] = new Bet (amount, number);
            } catch (NumberFormatException nfe) {
                Color color = Color.valueOf (parts[1]);
                this.bets [index] = new Bet (amount, color);
            }
        }
        in.close();
    }
}

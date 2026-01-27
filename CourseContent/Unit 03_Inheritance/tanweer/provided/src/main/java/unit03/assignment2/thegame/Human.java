package unit03.assignment2.thegame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human implements Player {
    private static final String DISCARD = "d";
    private static final String PASS = "p";
    private static final String Y = "Y";
    private static final String YES = "YES";

    private final Hand hand;
    private final Scanner scanner;

    public Human(Hand hand) {
        this.hand = hand;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Move nextMove() {
        while(true) {
            System.out.print("d(iscard) or p(ass) >> ");
            String response = scanner.nextLine().toLowerCase();
            switch(response) {
                case DISCARD:
                    return Move.DISCARD;
                case PASS:
                    return Move.PASS;
                default:
                    System.err.println("Invalid move. Try again.");
                    break;
            }
        }
    }

    @Override
    public Discard discard() {
        while(true) {
            try {
                System.out.print("card number >> ");
                int card = this.scanner.nextInt();
                System.out.print("pile number >> ");
                int pileNumber = this.scanner.nextInt();
                this.scanner.nextLine(); // clear out what's left
                if(this.hand.remove(card)) {
                    return new Discard(card, pileNumber);
                } else {
                   System.err.println("Card must be in hand."); 
                }
            } catch(InputMismatchException e) {
                System.err.println("Input must be an integer.");
                scanner.nextLine();
            }
        }
    }

    @Override
    public boolean deal(int card) {
        return this.hand.deal(card);
    } 
    
    @Override
    public boolean confirmGameOver() {
        System.out.println("Are you sure? This will end the game.");
        System.out.print("Y/N? >> ");
        String answer = scanner.nextLine().toUpperCase();
        return answer.equals(Y) || answer.equals(YES);
    }

    @Override
    public boolean handIsFull() {
        return this.hand.isFull();
    }

    @Override
    public boolean handIsEmpty() {
        return this.hand.isEmpty();
    }

    @Override
    public String toString() {
        return "Human: " + this.hand;
    }
}

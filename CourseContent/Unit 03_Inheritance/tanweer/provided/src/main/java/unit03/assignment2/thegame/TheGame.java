package unit03.assignment2.thegame;

import unit03.assignment1.thegame.AscendingPile;
import unit03.assignment1.thegame.Deck;
import unit03.assignment1.thegame.DescendingPile;
import unit03.assignment1.thegame.DiscardPile;

public class TheGame {
    private final Table table;
    private final Player player;

    public TheGame(Table table, Player player) {
        this.table = table;
        this.player = player;
    }

    public void play() {
        boolean gameOver = false;
        int turn = 0;
        while(!gameOver) {
            turn += 1;
            int played = 0;
            System.out.println("<---------------- Turn #" + turn 
                + " ---------------->");
            while(!table.deckIsEmpty() && !player.handIsFull()) {
                int card = table.draw();
                System.out.println("Dealing " + card + " to player.");
                player.deal(card);
            }
            boolean noPass = true;
            while(noPass) {
                System.out.println(table);
                System.out.println(player);
                System.out.println("You have played " + played 
                    + " cards this turn.");
                Move move = player.nextMove();
                if(move == Move.DISCARD) {
                    Discard discard = player.discard();
                    System.out.println(discard);
                    if(table.discard(discard)) {
                        System.out.println("Nice move!");
                        played += 1;
                    } else {
                        System.err.println("Discard failed. Try again.");
                        player.deal(discard.getCard());
                    }

                    if(player.handIsEmpty()) {
                        System.out.println("You played all of your cards!");
                        noPass = false;
                    }
                } else if(move == Move.PASS) {
                    // the player must make at least two plays.
                    if(played >= 2) {
                        noPass = false;
                    } else if(player.confirmGameOver()) {
                        gameOver = true;
                        noPass = false;
                    }
                }
            }

            if(table.deckIsEmpty() && player.handIsEmpty()) {
                gameOver = true;
            }
            
        }
    
        if(table.deckIsEmpty() && player.handIsEmpty()) {
            System.out.println("Game over! You won!");
        } else {
            System.out.println("Game over. You lost. Have a nice day!");
        }
    }

    public static void main(String[] args) {
        DiscardPile[] piles = {new AscendingPile(), new DescendingPile(20),
            new DescendingPile(20), new AscendingPile()};
        Deck deck = new Deck(19);
        deck.shuffle();

        Table table = new Table(piles, deck);

        Hand hand = new Hand(8);
        Player player = new Human(hand);

        TheGame game = new TheGame(table, player);
        game.play();
    }
}

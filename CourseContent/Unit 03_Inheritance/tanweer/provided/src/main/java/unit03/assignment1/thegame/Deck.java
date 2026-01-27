package unit03.assignment1.thegame;

import java.util.Random;

/**
 * Represents a deck of cards in The Game. The deck contains 98 unique cards
 * numbered sequentially from 2 to 99.
 * 
 * @author GCCIS Faculty
 */
public class Deck {
    /**
     * Used to shuffle the deck.
     */
    private static final Random RNG = new Random();

    /**
     * The cards in the deck - numbered sequentially from 2 to 99.
     */
    private int[] cards;

    /**
     * The location of the top card in the deck.
     */
    private int top;

    /**
     * Creates a new, unshuffled deck of 98 unique cards numbered sequentially 
     * from 2 to 99.
     */
    public Deck() {
        this(99);
    }

    /**
     * Overloaded constructor that can be used to create a deck to play a 
     * smaller game - the deck contains cards from 2 to maxValue.
     * 
     * @param maxValue The maximum value of a card in the deck.
     */
    public Deck(int maxValue) {
        this.cards = new int[maxValue - 1];
        for(int i=0; i<this.cards.length; i++) {
            this.cards[i] = i + 2;
        }
        this.top = 0;
    }

    /**
     * Shuffles the deck using the Fisher-Yates shuffling algorithm.
     */
    public void shuffle() {
        int length = this.cards.length;
        for(int i=length-1; i>0; i--) {
            int j = RNG.nextInt(0, i+1);
            int tmp = cards[i];
            cards[i] = cards[j];
            cards[j] = tmp;
        }
        this.top = 0;
    }

    /**
     * Returns the number of cards remaining to be drawn.
     * 
     * @return The number of cards remaining to be drawn.
     */
    public int remainingCardCount() {
        return this.cards.length - top;
    }

    /**
     * Draws the top card from the deck. If the deck is empty, an exception 
     * will be thrown.
     * 
     * @return The top card on the deck.
     */
    public int draw() {
        int card = this.cards[top];
        top++;
        return card;
    }

    @Override
    public String toString() {
        int remaining = remainingCardCount();
        return "[" + (remaining > 9 ? "" : "0") 
            + Integer.toString(remaining) + "]";
    }
}

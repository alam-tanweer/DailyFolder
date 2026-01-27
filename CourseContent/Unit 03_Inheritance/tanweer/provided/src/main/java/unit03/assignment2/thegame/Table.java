package unit03.assignment2.thegame;

import unit03.assignment1.thegame.Deck;
import unit03.assignment1.thegame.DiscardPile;

public class Table {
    private DiscardPile[] piles;
    private Deck deck;

    public Table(DiscardPile[] piles, Deck deck) {
        this.piles = piles;
        this.deck = deck;
    }

    public int draw() {
        return deck.draw();
    }

    public boolean discard(Discard discard) {
        DiscardPile pile = piles[discard.getPileNumber()-1];
        return pile.discard(discard.getCard());
    }

    public int numberOfPiles() {
        return this.piles.length;
    }

    public int getTopCard(int pileNumber) {
        return this.piles[pileNumber - 1].getTopCard();
    }

    public boolean deckIsEmpty() {
        return deck.remainingCardCount() == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Deck: ");
        builder.append(deck);
        builder.append("\nDiscard Piles:\n");
        builder.append("1: ");
        builder.append(piles[0]);
        for(int i=1; i<piles.length; i++) {
            builder.append("\n");
            builder.append(i + 1);
            builder.append(": ");
            builder.append(piles[i]);
        }
        return builder.toString();
    }
}

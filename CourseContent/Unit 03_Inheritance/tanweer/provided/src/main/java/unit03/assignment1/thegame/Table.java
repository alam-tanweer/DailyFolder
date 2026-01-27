package unit03.assignment1.thegame;

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

    public boolean discard(int card, int pileNumber) {
        DiscardPile pile = piles[pileNumber];
        return pile.discard(card);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(deck);
        builder.append("\n");
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

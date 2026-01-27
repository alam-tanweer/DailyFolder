package unit03.assignment1.thegame;

/**
 * An abstract class representing a discard pile in The Game.
 * 
 * @author GCCIS Faculty
 */
public abstract class DiscardPile {
    /**
     * The top card in the pile.
     */
    private int topCard;

    /**
     * The number of cards that have been discarded into this pile.
     */
    private int cardCount;

    /**
     * Creates a new discard pile with the specified initial top card.
     * 
     * @param topCard The initial top card.
     */
    public DiscardPile(int topCard) {
        this.topCard = topCard;
        this.cardCount = 1;
    }

    /**
     * Returns the top card on the pile.
     * 
     * @return The top card on the pile.
     */
    public int getTopCard() {
        return this.topCard;
    }

    /**
     * Returns the number of cards that have been discarded to this pile 
     * (including the first card).
     * 
     * @return The number of cards that have been discarded to this pile
     * (including the first card).
     */
    public int getCardCount() {
        return this.cardCount;
    }

    /**
     * Attempts to discard a card intto the deck. If the card follow the rules 
     * of this deck, it is discarded. Otherwise, it is ignored.
     * 
     * @param card The card being discarded to this deck.
     * @return True if the card follows the rules of this deck and was 
     * discarded. False if the card was not discarded.
     */
    public abstract boolean discard(int card);


    /**
     * Returns the rules that governing which cards may be discarded to this
     * pile. 
     * 
     * @return The rules governing which cards may be discarded to this pile.
     */
    public abstract String getRules();

    /**
     * Helper method that sets the top card in the pile. Calling this method
     * also increments the number of cards in the pile.
     * 
     * @param topCard The new top card.
     */
    protected void setTopCard(int topCard) {
        this.topCard = topCard;
        this.cardCount++;
    }
}

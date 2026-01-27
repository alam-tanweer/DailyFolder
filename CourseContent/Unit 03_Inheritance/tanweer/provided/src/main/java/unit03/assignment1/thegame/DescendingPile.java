package unit03.assignment1.thegame;

/**
 * An implementation of discard pile that allows cards to be discarded in 
 * descending order. A card may also be discarded it if is exactly 10 greater
 * than the top card. For example, if the top card is 67, any card with a value 
 * less than 67 may be played. A card with a value of 77 may also be played
 * (because it is exactly 10 greater than 67).
 * 
 * @author GCCIS Faculty
 */
public class DescendingPile extends DiscardPile {
    public static final String RULES = "Cards must be discarded in descending"
        + " order unless the card is exactly 10 greater than the top card.";

    /**
     * Creates a new descending pile that starts with 100.
     */
    public DescendingPile() {
        super(100);
    }

    /**
     * Overloaded constructor added to make "smaller" decks capable of playing
     * a shorter game.
     * 
     * @param initialValue The initial value of the top card on the deck.
     */
    public DescendingPile(int initialValue) {
        super(initialValue);
    }

    /**
     * Allows the card to be discarded if it is less than the top card or
     * exactly 10 greater than the top card.
     */
    @Override
    public boolean discard(int card) {
        int topCard = getTopCard();
        if(card < topCard || (card == (topCard + 10))) {
            setTopCard(card);
            return true;
        }
        return false;
    }

    @Override
    public String getRules() {
        return RULES;
    }

    @Override
    public String toString() {
        return "-{" + getTopCard() + "}";
    }
}

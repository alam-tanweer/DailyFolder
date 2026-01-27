package unit03.assignment1.thegame;

/**
 * An implementation of discard pile that allows cards to be discarded in 
 * ascending order. A card may also be discarded it if is exactly 10 less than
 * the top card. For example, if the top card is 27, any card with a value 
 * greater than 27 may be played. A card with a value of 17 may also be played
 * (because it is exactly 10 less than 27).
 * 
 * @author GCCIS Faculty
 */
public class AscendingPile extends DiscardPile {
    public static final String RULES = "Cards must be discarded in ascending"
        + " order unless the card is exactly 10 less than the top card.";

    /**
     * Creates a new ascending pile that starts with 1.
     */
    public AscendingPile() {
        super(1);
    }

    /**
     * Allows the card to be discarded if it is greater than the top card or
     * exactly 10 less than the top card.
     */
    @Override
    public boolean discard(int card) {
        int topCard = getTopCard();
        if(card > topCard || card == (topCard - 10)) {
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
        return "+{" + getTopCard() + "}";
    }
}

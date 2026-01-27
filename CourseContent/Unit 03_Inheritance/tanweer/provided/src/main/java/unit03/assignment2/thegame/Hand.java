package unit03.assignment2.thegame;

public class Hand {
    private static final int EMPTY_INDEX = -1;

    private final int[] cards;
    private int last;

    public Hand(int capacity) {
        this.cards = new int[capacity];
        this.last = EMPTY_INDEX;
    }

    public boolean deal(int card) {
        int newLast = last + 1;
        if(newLast < cards.length) {
            this.cards[newLast] = card;
            this.last = newLast;
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return this.last == cards.length - 1;
    }

    public boolean isEmpty() {
        return this.last == -1;
    }

    public boolean remove(int card) {
        for(int index=0; index<=last; index++) {
            if(cards[index] == card) {
                cards[index] = cards[last];
                cards[last--] = 0;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        if(last > -1) {
            builder.append(cards[0]);
            for(int i=1; i<=last; i++) {
                builder.append(", ");
                builder.append(cards[i]);
            }
        }
        builder.append("]");
        return builder.toString();
    }

    public static void main(String[] args) {
        Hand hand = new Hand(8);
        hand.deal(12);
        hand.deal(5);
        hand.deal(97);
    }
}

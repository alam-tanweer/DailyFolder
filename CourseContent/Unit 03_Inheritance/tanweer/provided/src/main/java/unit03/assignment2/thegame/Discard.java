package unit03.assignment2.thegame;

public class Discard {
    private int card;
    private int pileNumber;

    public Discard(int card, int pileNumber) {
        this.card = card;
        this.pileNumber = pileNumber;
    }

    public int getCard() {
        return card;
    }

    public int getPileNumber() {
        return pileNumber;
    }

    @Override
    public String toString() {
        return "Discarding " + this.card + " onto pile " + this.pileNumber 
            + ".";
    }
}

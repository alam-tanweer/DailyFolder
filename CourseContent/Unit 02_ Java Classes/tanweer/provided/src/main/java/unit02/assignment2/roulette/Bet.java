package unit02.assignment2.roulette;

public class Bet {
    private int amount;
    private int number;
    private Color color;

    public Bet (int amount, int number) {
        this.amount = amount;
        this.number = number;
        this.color = null;
    }

    public Bet (int amount, Color color) {
        this.amount = amount;
        this.color = color;
        this.number = -1;
    }

    public int getAmount() {
        return amount;
    }

    public Color getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public boolean isNumberBet () {
        return color == null;
    }

}

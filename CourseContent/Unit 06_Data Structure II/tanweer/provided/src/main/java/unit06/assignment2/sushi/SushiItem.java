package unit06.assignment2.sushi;

import java.util.Random;

public class SushiItem implements Comparable <SushiItem>{
    private final int number;
    private final int weight;
    private final int cost;

    public SushiItem (int number) {
        Random random = new Random ();
        this.number = number;
        weight = random.nextInt(80) + 20;
        cost = random.nextInt (30) + 10;
    }

    @Override
    public String toString() {
        return String.format ("Sushi{number=%d, weight=%d grams, $%d}", number, weight, cost);
    }

    public int getNumber() {
        return number;
    }

    public int getCost() {
        return cost;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo (SushiItem o) {
        return o.weight - weight;
    }
}

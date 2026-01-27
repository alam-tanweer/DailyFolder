package unit03.assignment1.thegame;

public class TheGame {
    public static void main(String[] args) {
        DiscardPile[] piles = {new AscendingPile(), new DescendingPile(),
            new DescendingPile(), new AscendingPile()};
        Deck deck = new Deck();

        Table table = new Table(piles, deck);

        System.out.println(table);
    }
}

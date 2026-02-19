package unit06.assignment2.sushi;

import java.util.Stack;

public class Order {
    private final Stack <SushiItem> bag;
    private int bill;

    public Order () {
        bag = new Stack<> ();
        bill = 0;
    }

    public void addItem (SushiItem item) {
        bill += item.getCost();
        bag.push (item);
    }

    public SushiItem removeItem () {
        return bag.pop();
    }

    public boolean bagIsEmpty () {
        return bag.empty ();
    }

    public int getBill () {
        return bill;
    }
}

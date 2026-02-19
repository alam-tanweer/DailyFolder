package unit06.assignment2.sushi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;


public class Case {
    private final Map <Integer, SushiItem> displayCase;
    private final static int NUM_CASE_ITEMS = 25;
    private final static Random random = new Random ();

    public Case () {
        displayCase = new HashMap<> ();
        for (int i = 0; i < NUM_CASE_ITEMS; i++) {
            SushiItem item = new SushiItem (i);
            displayCase.put (i, item);
        }
    }

    public SushiItem getSushi (int number) {
        return displayCase.remove (number);
    }

    public Set <Integer> takeOrder (int numItems) {
        Set<Integer> order = new HashSet<>();
        for (int i = 0; i < numItems; i++) {
            while (order.size() != numItems + 1) {
                order.add (random.nextInt (displayCase.size()));
            }
        }
        return order;
    }

    public Order bagOrder (Set <Integer> wantedItems) {
        Queue <SushiItem> cashier = new PriorityQueue<>();
        Order order = new Order();

        for (Integer item: wantedItems) {
            cashier.add (displayCase.remove(item));
        }

        while (!cashier.isEmpty()) {
            order.addItem (cashier.remove());
        }

        return order;
    }

    public static void main(String[] args) {
        Case sushiCase = new Case ();
        System.out.println ("Welcome to Shinji's Sushi Shop!");
        System.out.print ("The cashier takes your order: ");
        int numItems = random.nextInt (5) + 3;
        Set <Integer> wantedItems = sushiCase.takeOrder (numItems);
        for (int item: wantedItems) {
            System.out.print (item + " ");
        }
        System.out.println ();
        
        System.out.println ("The cashier prepares your order.");
        Order order = sushiCase.bagOrder (wantedItems);

        System.out.println ("That will be $" + order.getBill() + ".\nHere is your order, please come again.");

        System.out.println ("Back at your aprtment, you take out your sushi and eat it ...");
        while (!order.bagIsEmpty()) {
            SushiItem item = order.removeItem();
            System.out.println ("Eating " + item + " ... yum!");
        }
    }
}

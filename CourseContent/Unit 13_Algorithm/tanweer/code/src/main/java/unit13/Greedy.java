package unit13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import unit13.knapsack.Item;
import unit13.knapsack.ItemSets;
import unit13.knapsack.Knapsack;
import unit13.knapsack.ValueComparator;

/*
FUNCTION makeChange(price, payment)

    CREATE empty list change

    difference ← payment - price

    FOR EACH currency IN [DOLLAR, QUARTER, DIME, NICKEL, PENNY] DO

        WHILE difference ≥ currency.value DO
            ADD currency TO change
            difference ← difference - currency.value
        END WHILE

    END FOR

    RETURN change

END FUNCTION

    public static List<Currency> makeChange(double price, double payment) {
        List<Currency> change = new ArrayList<>();

        double difference = payment - price;

        Currency[] currencies = {
            Currency.DOLLAR,
            Currency.QUARTER,
            Currency.DIME,
            Currency.NICKEL,
            Currency.PENNY
        };

        for (Currency currency : currencies) {
            while (difference >= currency.getValue()) {
                change.add(currency);
                difference -= currency.getValue();
            }
        }

        return change;
    }

*/
public class Greedy {
    public static List<Currency> makeChange(double price, double payment) {
        List<Currency> change = new ArrayList<>();
        double difference = payment - price;

        difference = countChange(difference, Currency.DOLLAR, change);
        difference = countChange(difference, Currency.QUARTER, change);
        difference = countChange(difference, Currency.DIME, change);
        difference = countChange(difference, Currency.NICKEL, change);
        difference = countChange(difference, Currency.PENNY, change);

        return change;

    }

    private static double countChange(double amount, Currency currency,List<Currency> change) {
        while (amount > currency.getValue()) {
            change.add(currency);
            amount -= currency.getValue();
        }
        return amount;
    }

    /**
            Define local optima
            pull one item from collection

     */
    // Knapsack problem
    // Using Item built in comparator.
    public static void packLightest(Knapsack knapsack, List<Item> items) {
        Collections.sort(items);
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item); // rejected if too heavy
        }
    }

    //Using value comparator
    public static void packMostValuable(Knapsack knapsack, List<Item> items) {
        Collections.sort(items, new ValueComparator());
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item); // rejected if too heavy
        }
    }

    // Price per pound
    public static void packBestRatio(Knapsack knapsack, List<Item> items) {
        Collections.sort(items, new PricePerPoundComparator());
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item); // rejected if too heavy
        }
    }    

    public static void main(String[] args) {
        System.out.println(makeChange(10.37, 20));

        Knapsack knapsack = new Knapsack(10);

        System.out.println("SPORTS SET");
        packLightest(knapsack, ItemSets.sportsSet());
        System.out.println("  lightest: " + knapsack);
        knapsack.empty();        
    }
}

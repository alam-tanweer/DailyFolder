package unit08.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import unit08.examples.knapsack.Item;
import unit08.examples.knapsack.ItemSets;
import unit08.examples.knapsack.Knapsack;
import unit08.examples.knapsack.ValueComparator;

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

    private static double countChange(double amount, Currency currency, 
        List<Currency> change) {
        while(amount > currency.getValue()) {
            change.add(currency);
            amount -= currency.getValue();
        }
        return amount;
    }

    // BEGIN KNAPSACK: STUDENTS ARE EXPECTED TO WRITE ONE OF THE METHODS BELOW
    // (NOT ALL OF THEM)

    public static void packLightest(Knapsack knapsack, List<Item> items) {
        Collections.sort(items);
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item); // rejected if too heavy
        }
    }

    public static void packHeaviest(Knapsack knapsack, List<Item> items) {
        Collections.sort(items, new HeavyWeightComparator());
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item); // rejected if too heavy
        }
    }

    public static void packMostValuable(Knapsack knapsack, List<Item> items) {
        Collections.sort(items, new ValueComparator());
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item); // rejected if too heavy
        }
    }

    public static void packBestRatio(Knapsack knapsack, List<Item> items) {
        Collections.sort(items, new PricePerPoundComparator());
        while(items.size() > 0) {
            Item item = items.remove(0);
            knapsack.pack(item); // rejected if too heavy
        }
    }

    // END KNAPSACK: STUDENTS ARE EXPECTED TO WRITE ONE OF THE METHODS ABOVE
    // (NOT ALL OF THEM)

    public static void main(String[] args) {
        System.out.println(makeChange(10.37, 20));

        Knapsack knapsack = new Knapsack(10);

        System.out.println("SPORTS SET");
        packLightest(knapsack, ItemSets.sportsSet());
        System.out.println("  lightest: " + knapsack);
        knapsack.empty();
        packHeaviest(knapsack, ItemSets.sportsSet());
        System.out.println("  heaviest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack, ItemSets.sportsSet());
        System.out.println("  valuable: " + knapsack);
        knapsack.empty();
        packBestRatio(knapsack, ItemSets.sportsSet());
        System.out.println("  ratio: " + knapsack);
        knapsack.empty();

        System.out.println("ELECTRONICS SET");
        packLightest(knapsack, ItemSets.electronicsSet());
        System.out.println("  lightest: " + knapsack);
        knapsack.empty();
        packHeaviest(knapsack, ItemSets.electronicsSet());
        System.out.println("  heaviest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack, ItemSets.electronicsSet());
        System.out.println("  valuable: " + knapsack);
        knapsack.empty();
        packBestRatio(knapsack, ItemSets.electronicsSet());
        System.out.println("  ratio: " + knapsack);
        knapsack.empty();

        System.out.println("TOY SET");
        packLightest(knapsack, ItemSets.toySet());
        System.out.println("  lightest: " + knapsack);
        knapsack.empty();
        packHeaviest(knapsack, ItemSets.toySet());
        System.out.println("  heaviest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack, ItemSets.toySet());
        System.out.println("  valuable: " + knapsack);
        knapsack.empty();
        packBestRatio(knapsack, ItemSets.toySet());
        System.out.println("  ratio: " + knapsack);
        knapsack.empty();

        System.out.println("METAL SET");
        packLightest(knapsack, ItemSets.metalSet());
        System.out.println("  lightest: " + knapsack);
        knapsack.empty();
        packHeaviest(knapsack, ItemSets.metalSet());
        System.out.println("  heaviest: " + knapsack);
        knapsack.empty();
        packMostValuable(knapsack, ItemSets.metalSet());
        System.out.println("  valuable: " + knapsack);
        knapsack.empty();
        packBestRatio(knapsack, ItemSets.metalSet());
        System.out.println("  ratio: " + knapsack);
        knapsack.empty();
        
    }
}

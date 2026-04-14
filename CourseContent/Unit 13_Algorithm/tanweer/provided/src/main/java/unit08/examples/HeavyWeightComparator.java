package unit08.examples;

import java.util.Comparator;

import unit08.examples.knapsack.Item;

public class HeavyWeightComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o2.getWeight() - o1.getWeight();
    }
    
}

package unit13;

import java.util.Comparator;

import unit13.knapsack.Item;

public class PricePerPoundComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        double ppp1 = (double)o1.getValue() / o1.getWeight();
        double ppp2 = (double)o2.getValue() / o2.getWeight();

        return ppp1 <= ppp2 ? -1 : 1;
    }
    
}

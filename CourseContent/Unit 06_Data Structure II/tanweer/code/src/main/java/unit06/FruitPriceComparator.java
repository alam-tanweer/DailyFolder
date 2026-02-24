package unit06;

import java.util.*;

public class FruitPriceComparator implements Comparator<Fruit> {

    @Override
    public int compare(Fruit a, Fruit b) {
        double diff = a.getPrice() - b.getPrice();
        // return (int)diff; // here to show the wrong way to do it
        if(diff < 0) {
            return -1;
        } else if(diff > 0) {
            return 1;
        } else {
            // return 0;
            return a.getName().compareTo(b.getName());
        }
    }

    public static void main(String[] args) {
        List<Fruit> fruit = new ArrayList<>();
        fruit.add(new Fruit("Peach", 2.25));
        fruit.add(new Fruit("Banana", 2.0));
        fruit.add(new Fruit("Apple", 2.0));
        fruit.add(new Fruit("Mango", 3.75));
        fruit.add(new Fruit("Plum", 1.50));

        System.out.println(fruit);
        Collections.sort(fruit, new FruitPriceComparator());
        System.out.println(fruit);
    }
    
}

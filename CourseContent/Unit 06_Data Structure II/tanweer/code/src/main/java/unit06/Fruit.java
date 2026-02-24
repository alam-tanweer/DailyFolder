package unit06;

import java.util.*;

public class Fruit implements Comparable<Fruit> {
    private String name;
    public String getName() {
        return name;
    }

    private double price;

    public Fruit(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { // needed by comparator
        return this.price;
    }

    @Override
    public int compareTo(Fruit other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return this.name + " $" + this.price;
    }

    public static void main(String[] args) {
        List<Fruit> fruit = new ArrayList<>();
        fruit.add(new Fruit("Peach", 2.25));
        fruit.add(new Fruit("Apple", 2.0));
        fruit.add(new Fruit("Mango", 3.75));
        fruit.add(new Fruit("Plum", 1.50));
        fruit.add(new Fruit("Banana", 1.0));

        System.out.println(fruit);
        Collections.sort(fruit);
        System.out.println(fruit);
    }

}

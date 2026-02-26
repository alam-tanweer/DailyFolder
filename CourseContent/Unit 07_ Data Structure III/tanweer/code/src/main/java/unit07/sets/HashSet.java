package unit07.sets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import unit07.maps.*;

public class HashSet <E> implements Set<E>,Iterable<E> {
    private final HashMapChaining<E, Object> map;

    public HashSet() {
        this.map = new HashMapChaining<>();
    }

    @Override
    public boolean add(E element) {
        if (map.containsKey(element)) {
            return false;
        } else {
            return map.add(element, null);
        }
    }

    @Override
    public boolean contains(E element) {
        return map.containsKey(element);
    }

    @Override
    public boolean remove(E element) {
        if (map.containsKey(element)) {
            map.remove(element);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return map.iterator();
    }

    @Override
    public String toString() {
        List<String> values = new ArrayList<>();
        for (E element : this) {
            values.add(element.toString());
        }
        return "{" + String.join(", ", values) + "}";
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        System.out.println("Set contains 'Hello': " + set.contains("Hello"));
        System.out.println("Set size: " + set.size());

        System.out.print("Set elements: ");
        for (String element : set) {
            System.out.print(element + ", ");
        }
        System.out.println();

        set.remove("Hello");
        System.out.println("Set contains 'Hello' after removal: " + set.contains("Hello"));
        System.out.println("Set size after removal: " + set.size());
    }
}

package unit07.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class HashMap<K, V> implements Map<K, V> {
    private List<Element> elements;
    private int size;
    private static final int INITIAL_CAPACITY = 3;

    public HashMap() {
        elements = new ArrayList<>();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            elements.add(null);
        }
        size = 0;
    }

    // Private class
    private class Element {
        private K key;
        private V value;

        Element(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + ":" + value;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int index = 0;
            private int returned = 0;

            @Override
            public boolean hasNext() {
                return returned < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                while (index < elements.size() && elements.get(index) == null) {
                    index++;
                }
                if (index >= elements.size()) {
                    throw new NoSuchElementException();
                }

                K key = elements.get(index).key;
                index++;
                returned++;
                return key;
            }
        };
    }

    @Override
    public boolean add(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key cannot be null");
        }

        // Math.Abs use as sometimes hashcode can return a -ve value.
        // int index = Math.abs(key.hashCode() % elements.size());
        int index = calculateIndex(key);
        Element atIndex = elements.get(index);

        // If not empty, check if key matches
        if (atIndex != null) {
            if (atIndex.key.equals(key)) {       //TALK ABOUT CUSTOM CLASS IMPLEMENTING HASHCODE AND EQUAL
                // keys match: update stored value, return true (per slide)
                atIndex.value = value;
                return true;
            } else {
                // collision with different key: return false (per slide)
                return false;
            }
        }

        // Else: empty slot, store new element, increase size, return true
        elements.set(index, new Element(key, value));
        size++;
        return true;
    }

    private int calculateIndex(K key) {
        // Compute bucket index for a key using its hash code.
        return Math.abs(key.hashCode()) % elements.size();
    }

    @Override
    public boolean containsKey(K key) {
        // if (key == null) {
        //     return false;
        // }

        // 7.8
        int index = calculateIndex(key);
        Element atIndex = elements.get(index);

        return atIndex != null && atIndex.key.equals(key);
    }

    @Override
    public V remove(K key) {

        if (!containsKey(key)) {
            return null;
        }

        int index = calculateIndex(key);

        V temp = elements.get(index).value;
        
        elements.set(index, null);
        
        size--;
        
        return temp;
    }

    @Override
    public V get(K key) {
        // 7.9
        if (containsKey(key)) {
            int index = calculateIndex(key);
            return elements.get(index).value;
        }

        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        String data = "";
        for (Element e : elements) {
            data += e + " : ";
        }
        return data;
    }

    public static void main(String[] args) {
        // HashMap<String, Integer> map = new HashMap<>();

        // int i = 0;
        // while (true) {
        //     String key = "key" + i;
        //     boolean result = map.add(key, i);
        //     System.out.println("add(" + key + ", " + i + ") => " + result + "   map=" + map);

        //     if (!result) {
        //         System.out.println("First FALSE happened after attempting to add item #" + (i + 1));
        //         break;
        //     }
        //     i++;
        // }

        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(map.add("one", 1));
        System.out.println(map.add("two", 2));
        System.out.println(map.add("three", 3));
        System.out.println(map.add("four", 4));
        System.out.println("Size: " + map.size()); // Size: 3
        System.out.println("Contains 'two': " + map.containsKey("two")); // true
        System.out.println("Value for 'three': " + map.get("three")); // 3

        System.out.println("Keys: ");
        for (String key : map) {
            System.out.println(key + " " + ", hashcode: " + key.hashCode() + ", index " + key.hashCode() % 3);
        }
        System.out.println();

        map.remove("one");
        System.out.println("Size after removing 'one': " + map.size()); // Size: 2        
    }
}

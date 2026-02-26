package unit07.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashMap<K,V> implements Map<K,V> {
    /**
     * Buckets holding lists of elements. Each bucket is a LinkedList of Element.
     * The outer list is fixed-size (wrapped with Collections.unmodifiableList)
     * but the inner lists are mutable and hold the entries.
     */
    private List<List<Element>> elements;

    /** Number of key/value pairs stored in the map. */
    private int size;

    /** Initial number of buckets. */
    private static final int INITIAL_CAPACITY = 3;

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

    /**
     * Constructs a new HashMap with a small initial number of buckets.
     */
    public HashMap () {
        List<List<Element>> list = new ArrayList<>();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            list.add (new LinkedList<>());
        }
        elements = Collections.unmodifiableList(list); 
    }

    private int calculateIndex (K key) {
        // Compute bucket index for a key using its hash code.
        return Math.abs(key.hashCode()) % elements.size();
    }

    private void resizeIfNeeded() {
        // Grow the number of buckets when load factor reaches 1 (size == buckets).
        if (size == elements.size()) {
            List<List<Element>> oldElements = elements;
            List<List<Element>> newElements = new ArrayList<>();
            for (int i = 0; i < oldElements.size() * 2; i++) {
                newElements.add(new LinkedList<>());
            }
            elements = Collections.unmodifiableList(newElements);
            // Rehash all existing entries into the new bucket structure.
            int oldSize = size;
            size = 0;

            for (List<Element> bucket : oldElements) {
                for (Element element : bucket) {
                    add(element.key, element.value);
                }
            }
            // size should equal oldSize after rehashing
            assert size == oldSize;
        }
    }

    @Override
    public boolean add(K key, V value) {
        int index = calculateIndex (key);
        for (Element element : elements.get(index)) {
            if (element.key.equals(key)) {
                element.value = value;
                return true;
            }
        }

        resizeIfNeeded();
        elements.get(index).add(new Element(key, value));
        size++;
        return true;
    }

    @Override
    public boolean containsKey(K key) {
        int index = calculateIndex(key);
        for (Element element : elements.get(index)) {
            if (element.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = calculateIndex(key);
        for (Element element : elements.get(index)) {
            if (element.key.equals(key)) {
                return element.value;
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int index = calculateIndex(key);
        for (Element element : elements.get(index)) {
            if (element.key.equals(key)) {
                elements.get(index).remove(element);
                size--;
                return element.value;
            }
        }
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private int bucketIndex = 0;
            private int elementIndex = 0;

            @Override
            public boolean hasNext() {
                while (bucketIndex < elements.size()) {
                    if (elementIndex < elements.get(bucketIndex).size()) {
                        return true;
                    } else {
                        bucketIndex++;
                        elementIndex = 0;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                K key = elements.get(bucketIndex).get(elementIndex).key;
                elementIndex++;
                return key;
            }
        };
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String[] elements = new String[size];
        for (int i = 0, bucketIndex = 0; bucketIndex < this.elements.size(); bucketIndex++) {
            for (Element element : this.elements.get(bucketIndex)) {
                elements[i++] = element.toString();
            }
        }
        return "{" + String.join(", ", elements) + "}";
    }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.add("one", 1);
        map.add("two", 2);
        map.add("three", 3);
        map.add("four", 4);
        System.out.println("Size: " + map.size()); // Size: 3
        System.out.println("Contains 'two': " + map.containsKey("two")); // true
        System.out.println("Value for 'three': " + map.get("three")); // 3

        System.out.print("Keys: ");
        for (String key : map) {
            System.out.print(key + " ");
        }
        System.out.println();

        map.remove("one");
        System.out.println("Size after removing 'one': " + map.size()); // Size: 2
    }
}

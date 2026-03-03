package unit07.maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashMapChaining<K, V> implements Map<K, V> {
    // private List<Element> elements;
    private List<List<Element>> elements; // Change
    private int size;
    private static final int INITIAL_CAPACITY = 3;

    public HashMapChaining() {
        List<List<Element>> list = new ArrayList<>();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            // elements.add(null);
            list.add(new ArrayList<>()); // change
        }
        elements = Collections.unmodifiableList(list); 
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

    private void resizeIfNeeded() {
        // Grow the number of buckets when load factor reaches 1 (size == buckets).
        if (size >= elements.size()) {
            List<List<Element>> oldElements = elements;
            List<List<Element>> newElements = new ArrayList<>();
            for (int i = 0; i < oldElements.size() * 2; i++) {
                newElements.add(new ArrayList<>());
            }
            // elements = Collections.unmodifiableList(newElements);
            elements = newElements;

            // Rehash all existing entries into the new bucket structure.
            int oldSize = size; // Not needed.
            size = 0;

            for (List<Element> bucket : oldElements) {
                for (Element element : bucket) {
                    add(element.key, element.value);
                }
            }
            // size should equal oldSize after rehashing
            assert size == oldSize; //Not needed.
        }
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
                    }
                    bucketIndex++;
                    elementIndex = 0;
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
    public boolean add(K key, V value) {
        resizeIfNeeded();
        int index = calculateIndex(key);
        for (Element element : elements.get(index)) {
            if (element.key.equals(key)) {
                element.value = value;
                return true;
            }
        }
        elements.get(index).add(new Element(key, value));
        size++;
        return true;
    }

    private int calculateIndex(K key) {
        // Compute bucket index for a key using its hash code.
        return Math.abs(key.hashCode()) % elements.size();
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null) {
            return false;
        }
        // With chainging option
        int index = calculateIndex(key);
        List<Element> data = elements.get(index);
        for (Element element : data) {
            if (element.key.equals(key)) {
                return true;
            }
        }

        return false;
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
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        String[] elements = new String[size];
        for (int i = 0, bucketIndex = 0; bucketIndex < this.elements.size(); bucketIndex++) {
            // System.out.println("Value stored at index : " + bucketIndex);
            for (Element element : this.elements.get(bucketIndex)) {
                System.out.println(element);
                elements[i++] = element.toString();
            }
        }
        return "{" + String.join(", ", elements) + "}";
    }

    public static void main(String[] args) {
        HashMapChaining<String, Integer> map = new HashMapChaining<>();
        map.add("one", 1);
        map.add("two", 2);
        map.add("three", 3);
        
        System.out.println("");        
        System.out.println("Size: " + map.size + "== " + map);        
        map.add("four", 4);
        System.out.println("");
        System.out.println("Size: " + map.size);            
        System.out.println("Size: " + map.size + "== " + map);    

        // System.out.println("Size: " + map.size()); // Size: 3
        // System.out.println("Contains 'two': " + map.containsKey("two")); // true
        // System.out.println("Value for 'three': " + map.get("three")); // 3

        // System.out.print("Keys: ");
        // for (String key : map) {
        //     System.out.print(key + " ");
        // }
        // System.out.println();

        // map.remove("one");
        // System.out.println("Size after removing 'one': " + map.size()); // Size: 2
    }
}

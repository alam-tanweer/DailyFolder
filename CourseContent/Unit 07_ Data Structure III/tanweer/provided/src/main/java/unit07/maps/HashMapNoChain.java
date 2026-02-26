package unit07.maps;

/** 
 * A simple hash map implementation without chaining for collision resolution.
 * If a collision occurs during an add operation, the operation fails.
 * 
 * Not a complete implementation but it's what students will write first
 * and then adjust to turn into the @HashMap with chaining.
 * 
 * @author Bruce Herring
 */

import java.util.ArrayList;
import java.util.List;

public class HashMapNoChain<K,V> implements Map<K,V> {
    private List<Element> elements;
    private int size;
    private static final int INITIAL_CAPACITY = 3;

    private class Element {
        private K key;
        private V value;

        Element(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashMapNoChain () {     
        List<Element> list = new ArrayList<>();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            list.add (null);
        }
        elements = list;
    }

    private int calculateIndex (K key) {
        return Math.abs(key.hashCode()) % elements.size();
    }

    @Override
    public boolean add(K key, V value) {
        int index = calculateIndex (key);
        if (elements.get(index) != null) {
            if (elements.get(index).key.equals(key)) {
                elements.get(index).value = value;
                return true;
            } else {
                return false; // Collision occurred
            }
        }

        elements.set(index, new Element(key, value));
        size++;
        return true;
    }

    @Override
    public boolean containsKey(K key) {
        int index = calculateIndex(key);
        if (elements.get(index) != null && elements.get(index).key.equals(key)) {
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (containsKey(key)) {
            int index = calculateIndex(key);
            return elements.get(index).value;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        if (containsKey (key)) {
            int index = calculateIndex(key);
            V value = elements.get(index).value;
            elements.set(index, null);
            size--;
            return value;
        }
        return null;
    }

    @Override
    public java.util.Iterator<K> iterator() {
        return new java.util.Iterator<K>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                while (currentIndex < elements.size()) {
                    if (elements.get(currentIndex) != null) {
                        return true;
                    }
                    currentIndex++;
                }
                return false;
            }

            @Override
            public K next() {
                while (currentIndex < elements.size()) {
                    if (elements.get(currentIndex) != null) {
                        K key = elements.get(currentIndex).key;
                        currentIndex++;
                        return key;
                    }
                    currentIndex++;
                }
                throw new java.util.NoSuchElementException();
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


    public static void main(String[] args) {
        HashMapNoChain<String, Integer> map = new HashMapNoChain<>();
        map.add("one", 1);
        map.add("two", 2);
        map.add("three", 3);
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

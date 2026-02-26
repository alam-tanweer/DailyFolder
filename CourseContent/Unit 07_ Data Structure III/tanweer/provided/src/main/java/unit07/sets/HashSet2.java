package unit07.sets;

/**
 * Originally I started with a full HashSet implementation but then changed
 * to a simpler version using HashMap. This is the original version.
 * @author Bruce Herring 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HashSet2<E> implements Set<E> {
    private List<List<E>> elements;
    private int size;
    private static final int INITIAL_CAPACITY = 3;

    public HashSet2 () {
        elements = new ArrayList<>();
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            elements.add (new LinkedList<>());
        }
    }

    private int calculateIndex (E element) {
        return Math.abs(element.hashCode()) % elements.size();
    }

    private void resizeIfNeeded() {
        if (size == elements.size()) {
            List<List<E>> oldElements = elements;
            elements = new ArrayList<>();
            for (int i = 0; i < oldElements.size() * 2; i++) {
                elements.add(new LinkedList<>());
            }
            size = 0;
            for (List<E> bucket : oldElements) {
                for (E element : bucket) {
                    add(element);
                }
            }
        }
    }

    @Override
    public boolean add(E element) {
        if (!contains(element)) {
            resizeIfNeeded();
            int index = calculateIndex(element);
            elements.get(index).add(element);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E element) {
        int index = calculateIndex(element);
        if (elements.get(index).contains(element)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(E element) {
        if (contains(element)) {
            int index = calculateIndex(element);
            elements.get(index).remove(element);
            size--;
            return true;
        }
        return false;    
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
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public static void main(String[] args) {
        HashSet2<String> set = new HashSet2<>();
        set.add("Hello");
        set.add("World");
        System.out.println("Set contains 'Hello': " + set.contains("Hello"));
        System.out.println("Set size: " + set.size());
        set.remove("Hello");
        System.out.println("Set contains 'Hello' after removal: " + set.contains("Hello"));
        System.out.println("Set size after removal: " + set.size());
    }
}

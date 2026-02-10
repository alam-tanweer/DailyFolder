package unit05;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private Object[] elements;
    private int size;

    public ArrayList() {
        elements = new Object[2];
        size = 0;
    }

    @Override
    public void append(E value) {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, size*2);
        }
        elements[size] = value;
        size++;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E)elements[index];
    }

    @Override
    public void set(int index, E value) {
        elements[index] = value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(elements, size);
    }
}

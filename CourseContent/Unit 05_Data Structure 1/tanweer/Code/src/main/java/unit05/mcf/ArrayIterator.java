package unit05.mcf;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private Object[] elements;
    private int index;
    private int size;
    
    public ArrayIterator(Object[] elements, int stopIndex) {
        this.elements = elements;
        this.size = stopIndex;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E next() {
        System.out.println("Next called.");
        E element = (E)elements[index];
        index++;
        return element;
    }
}

package unit05.assignment1.list;

import java.util.Arrays;
import unit05.List;

public class ArrayList<E> implements List<E> {
    private Object[] elements;
    private int size;

    public ArrayList() {
        elements = new Object[2];
        size = 0;
    }

    public ArrayList(List<E> list) {
        size = list.size();
        elements = new Object[size];
        for (int i = 0; i < size; i++) {
            elements[i] = list.get(i);
        }

    }

    @Override
    public void append(E value) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
        elements[size] = value;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elements[index];
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
    public String toString() {
        return Arrays.toString(elements);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (obj instanceof ArrayList) {
            ArrayList<E> otherList = (ArrayList<E>) obj;
            if (this.size() == otherList.size()) {
                for (int i = 0; i < size(); i++) {
                    if (!get(i).equals(otherList.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }
}

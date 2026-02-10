package unit05;

import java.util.Iterator;

public interface List<E> extends Iterable<E> {
    void append(E value);
    E get(int index);
    void set(int index, E value);
    int size();

    default Iterator<E> iterator() {
        throw new UnsupportedOperationException("itertaor() not supported");
    }
}

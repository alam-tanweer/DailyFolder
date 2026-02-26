package unit07.sets;

// public interface Set<E> extends Iterable<E> {
public interface Set<E>{
    boolean add(E element);
    boolean contains(E element);
    boolean remove(E element);
    int size();
    boolean isEmpty();
}

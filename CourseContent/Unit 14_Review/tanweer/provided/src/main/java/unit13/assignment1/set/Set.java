package unit13.assignment1.set;

public interface Set <E> extends Iterable <E> {

    void add (E e);
    void remove (E e);
    boolean contains (E e);
    int size ();   
}

package unit13.assignment1.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSet <E> implements Set <E> {
    private List<E> list;

    public ListSet () {
        list = new ArrayList<> ();
    }

    @Override
    public Iterator<E> iterator() {
        return new ListSetIterator<E> (list);
    }

    /**
     * O(N) complexity due to contains 
     */
    @Override
    public void add(E e) {
        if (!list.contains (e)) {
            list.add (e);  
        }
    }

    /**
     * O(N) complexity
     */
    @Override
    public void remove (E e) {
        list.remove (e);        
    }

    /**
     * O(N) complexity
     */
    @Override
    public boolean contains(E e) {
        return list.contains (e);
    }

    /**
     * O(C)
     */
    @Override
    public int size() {
        return list.size ();
    }
    
}

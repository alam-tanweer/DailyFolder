package unit06.assignment2.orderedset;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OrderedSet<E> implements Set<E> {
    private final Set<E> elements;
    private final List<E> order;

    public OrderedSet() {
        elements = new HashSet<>();
        order = new ArrayList<>();
    }


    @Override
    public boolean add(E value) {
        boolean changed = false;
        if(!elements.contains(value)) {
            elements.add(value);
            order.add(value);
            changed = true;
        } 
        return changed;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        boolean changed = false;
        for(E element : collection) {
            changed = changed || add(element);
        }
        return changed;
    }

    @Override
    public void clear() {
        elements.clear();
        order.clear();
    }

    @Override
    public boolean contains(Object obj) {
        return elements.contains(obj);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(Object element :collection) {
            if(!contains(element)) {
                return false;
            }
        }
        return true;
        
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return order.iterator();
    }

    @Override
    public boolean remove(Object obj) {
        boolean removed = elements.remove(obj);
        if(removed) {
            order.remove(obj);
        }
        return removed;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean changed = false;
        for(Object obj : collection) {
            changed = changed || remove(obj);
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean changed = false;

        Set<E> toRemove = new HashSet<>();
        for(E element : elements) {
            if(!collection.contains(element)) {
                toRemove.add(element);
                changed = true;
            }
        }
        removeAll(toRemove);

        return changed;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public Object[] toArray() {
        return order.toArray();
    }

    @Override
    public <T> T[] toArray(T[] type) {
        return order.toArray(type);
    }
    
    public static void main(String[] args) {
        Set<String> set = new OrderedSet<>();
        set.add("zzz");
        set.add("yyy");
        set.add("xxx");
        set.add("abc");
        set.add("def");
        set.add("ghi");
        set.add("zzz");
        set.add("yyy");
        set.add("xxx");
        set.add("abc");
        set.add("def");
        set.add("ghi");

        for(String s : set) {
            System.out.println(s);
        }
    }
}

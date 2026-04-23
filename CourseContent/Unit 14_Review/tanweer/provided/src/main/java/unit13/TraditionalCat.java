package unit13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TraditionalCat <T> implements Concatenator <T>, Iterable <T> {

    private List<T> list;

    public TraditionalCat () {
        list = new ArrayList<> ();
    }

    @Override
    public void add(T t) {
        list.add (t);
    }

    @Override
    public void remove(T t) {
        list.remove (t);
    }

    @Override
    public String concat() {
        String result = "";
        for (T item : list) {
            result += item;
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Caterator<> (list);
    }

    public static void main(String[] args) {
        TraditionalCat <Integer> cat = new TraditionalCat<> ();
        cat.add (1);
        cat.add (2);
        cat.add (3);

        System.out.println (cat.concat());
        for (int value : cat){
            System.out.println (value);
        }
    }
}

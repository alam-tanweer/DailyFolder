package unit13;

import java.util.Iterator;
import java.util.List;

public class Caterator<T> implements Iterator <T>{

    private List<T> list;
    private int index;

    public Caterator (List<T> list) {
        this.list = list;
        index = 0;
    }
    

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        T value = list.get (index);
        index++;
        return value;
    }
    
}

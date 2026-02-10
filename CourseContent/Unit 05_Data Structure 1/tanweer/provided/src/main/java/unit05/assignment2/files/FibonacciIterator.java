package unit05.assignment2.files;

import java.util.ArrayList;
import java.util.Iterator;

public class FibonacciIterator implements Iterator<Long> {
    private int index;
    private ArrayList<Long> arrayList;

    public FibonacciIterator(ArrayList<Long> arrayList) {
        this.arrayList = arrayList;
        this.index = 0;
    }

    @Override
    public Long next() {
        int currIndex = index;
        index++;
        return arrayList.get(currIndex);
    }

    @Override
    public boolean hasNext() {
        return index < arrayList.size();
    }
}

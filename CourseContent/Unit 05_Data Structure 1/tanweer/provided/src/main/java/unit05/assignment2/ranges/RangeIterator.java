package unit05.assignment2.ranges;

import java.util.Iterator;

public class RangeIterator implements Iterator<Integer> {
    private final Range range;
    private int position;

    public RangeIterator(Range range) {
        this.range = range;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < range.size();
    }

    @Override
    public Integer next() {
        int value = range.get(position);
        position++;
        return value;
    }
}

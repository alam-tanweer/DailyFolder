package unit05.assignment2.ranges;

import java.util.Iterator;

public class IntRange implements Range {
    private final int start;
    private final int step;
    private final int size;

    public IntRange(int start, int stop, int step) {
        this.start = start;
        this.step = step;

        int range = stop - start;
        int temp = range / step;
        temp += range % step == 0 ? 0 : 1;
        this.size = temp;
    }

    public IntRange(int start, int stop) {
        this(start, stop, 1);
    }

    public IntRange(int stop) {
        this(0, stop, 1);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        return start + (step * index);
    }

    public static void main(String[] args) {
        for (int i : new IntRange(2, 101, 2)) {
            System.out.println(i);
        }
    }

}

package unit05.assignment2.ranges;

import java.util.Iterator;

public class FibonacciRange implements Range {
    private final int size;

    public FibonacciRange(int size) {
        this.size = size;
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

        int fn_1 = 1;
        int fn_2 = 0;

        while (index > 1) {
            int temp = fn_1;
            fn_1 = fn_1 + fn_2;
            fn_2 = temp;
            index--;
        }

        return index == 1 ? fn_1 : fn_2;
    }

    public static void main(String[] args) {
        int count = 1;
        for (int i : new FibonacciRange(50)) {
            System.out.println(count + ": " + i);
            count++;
        }
    }

}

package unit05.assignment2.files;

import java.util.ArrayList;
import java.util.Iterator;

public class IterableFibonacci implements Iterable<Long> {
    private ArrayList<Long> arrayList;

    public IterableFibonacci(long a, long b) {
        arrayList = new ArrayList<>();
        arrayList.add(a);
        arrayList.add(b);
    }

    public void add() {
        int length = arrayList.size();
        long a = arrayList.get(length - 2);
        long b = arrayList.get(length - 1);
        arrayList.add(a + b);
    }

    public Long get(int index) {
        return arrayList.get(index);
    }

    public int size() {
        return arrayList.size();
    }

    @Override
    public Iterator<Long> iterator() {
        return new FibonacciIterator(arrayList);
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }

    public static void main(String[] args) {
        IterableFibonacci fib = new IterableFibonacci(3, 7);

        fib.add();
        fib.add();
        fib.add();

        System.out.println(fib); // [3, 7, 10, 17, 27]

        for (Long elt : fib) {
            System.out.print(elt + " ");
        }
        System.out.println();

        for (int i = 0; i < fib.size(); i++) {
            System.out.print(fib.get(i) + " ");
        }
        System.out.println();

    }
}

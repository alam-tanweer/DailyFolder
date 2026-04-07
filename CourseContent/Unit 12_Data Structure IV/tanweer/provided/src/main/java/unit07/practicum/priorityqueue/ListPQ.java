package unit07.practicum.priorityqueue;

import java.util.LinkedList;
import java.util.List;

public class ListPQ implements Queue<Integer> {
    private final List<Integer> list;

    public ListPQ() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(Integer value) {
        list.add(value);
    }

    @Override
    public Integer dequeue() {
        // search for the smallest value and return it
        int index = 0;
        int smallest = list.get(index);
        for (int i = 1; i < list.size(); i++) {
            int value = list.get(i);
            if (value < smallest) {
                smallest = value;
                index = i;
            }
        }
        list.remove(index);
        return smallest;
    }

    @Override
    public int size() {
        return list.size();
    }

}

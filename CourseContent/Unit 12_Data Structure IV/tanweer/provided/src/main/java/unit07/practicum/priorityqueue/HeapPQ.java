package unit07.practicum.priorityqueue;

public class HeapPQ implements Queue<Integer> {
    private final Heap heap;

    public HeapPQ() {
        heap = new ArrayHeap();
    }

    @Override
    public void enqueue(Integer value) {
        heap.add(value);
    }

    @Override
    public Integer dequeue() {
        return heap.remove();
    }

    @Override
    public int size() {
        return heap.size();
    }
}

package unit05;

public class ArrayQueue<E> implements Queue<E> {
    private Object[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue() {
        elements = new Object[10];
        front = 0;
        back = 0;
        size = 0;
    }


    @Override
    public void enqueue(E value) {
        // resize - Activity 4.1.10 (optional)
        if(size == elements.length) {
            Object[] bigger = new String[elements.length*2];
            for(int destination=0; destination<size; destination++) {
                int source = (front + destination) % size;
                bigger[destination] = elements[source];
            }
            elements = bigger;
            front = 0;
            back = size;
        }
        // main enqueue implementation
        elements[back] = value;
        back = (back + 1) % elements.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() {
        if(size == 0) {
            return null;
        } else {
            E value = (E)elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            size--;
            return value;
        }
    }

    @Override
    public int size() {
        return size;
    }
}

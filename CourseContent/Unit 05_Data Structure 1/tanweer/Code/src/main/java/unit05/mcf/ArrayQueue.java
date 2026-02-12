package unit05.mcf;

import java.util.Arrays;

public class ArrayQueue implements Queue {

    private String[] elements;
    private int front;
    private int back;
    private int size;

    public ArrayQueue() {
        elements = new String[4];
        front = 0;
        back = 0;
        size = 0;
    }

    @Override
    public void enqueue(String value) {
        // resize - Activity 4.1.10 (optional)
        if (size == elements.length) {
            String[] bigger = new String[elements.length * 2];
            // for (int destination = 0; destination < size; destination++) {
            //     int source = (front + destination) % size;
            //     bigger[destination] = elements[source];
            // }
            int destination = 0;
            for (int counter = front;counter <= size;counter++){
                bigger[destination] = elements[counter % size];
                destination++;
            }

            //5.8
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
    public String dequeue() {
        if (size == 0) {
            return null;
            // Potentially raise error
        } else {
            String value = (String) elements[front];
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

    @Override
    public String toString() {
        return "Queue{" + this.size() + ", " + Arrays.toString(elements) + "}";
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        q.dequeue();
        q.enqueue("4");
        q.enqueue("5");
        System.out.println(q);        
        q.enqueue("6");
        System.out.println(q);
        while(q.size>0) System.out.println(q.dequeue());
    }
}

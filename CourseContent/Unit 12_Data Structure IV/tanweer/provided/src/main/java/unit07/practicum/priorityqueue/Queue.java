package unit07.practicum.priorityqueue;

// provided code
public interface Queue<E> {
    void enqueue(E value);

    E dequeue();

    int size();
}
package unit05.gen;

import java.util.Iterator;

public interface Queue<E>  extends Iterable<E> {
    /**
     * Adds a new value to the queue.
     * 
     * @param value The value to add to the queue.
     */
    void enqueue(E value);

    /**
     * Removes and returns a value from the queue.
     * 
     * @return The value removed from the queue.
     */
    E dequeue();

    /**
     * Returns the number of elements in the queue.
     * 
     * @return The size of the queue.
     */
    int size();

    default Iterator<E> iterator(){
        throw new UnsupportedOperationException("Iterator is not supported.");
    }
}

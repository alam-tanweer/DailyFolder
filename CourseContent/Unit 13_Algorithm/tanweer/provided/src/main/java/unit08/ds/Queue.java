package unit08.ds;

/**
 * Defines the essential operations for a queue data structure.
 * 
 * @author GCCIS Faculty
 */
public interface Queue<E> {
    /**
     * Adds a new element to the back of the queue.
     * 
     * @param element The element to add to the back of the queue.
     */
    void enqueue(E element);

    /**
     * Removes and returns the element at the front of the queue.
     * 
     * @return The element at the front of the queue.
     */
    E dequeue();

    /**
     * Returns the number of elements in the queue.
     * 
     * @return The number of elements in the queue.
     */
    int size();
}
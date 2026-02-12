package unit05.mcf;

//5.4
public interface Queue {
    /**
     * Adds a new value to the queue.
     * 
     * @param value The value to add to the queue.
     */
    void enqueue(String value);

    /**
     * Removes and returns a value from the queue.
     * 
     * @return The value removed from the queue.
     */
    String dequeue();

    /**
     * Returns the number of elements in the queue.
     * 
     * @return The size of the queue.
     */
    int size();
}

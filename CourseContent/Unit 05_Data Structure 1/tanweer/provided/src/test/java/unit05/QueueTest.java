package unit05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Abstract test class that uses polymorphism to test any implementation of
 * a Queue interface.
 */
public abstract class QueueTest {
    /**
     * Must be implemented by concrete subclasses to return the specific type
     * of Queue to be tested.
     * 
     * @return The Queue to be tested.
     */
    public abstract Queue<Object> makeQueue();

    @Test
    public void create() {
        // setup - none

        // invoke
        Queue<Object> q = makeQueue();

        // analyze
        assertEquals(0, q.size());
    }

    @Test
    public void enqueueOne() {
        // setup
        String[] values = { "abc" };
        Queue<Object> q = makeQueue();

        // invoke
        q.enqueue(values[0]);

        // analyze
        assertEquals(1, q.size());
    }

    @Test
    public void dequeueOne() {
        // setup
        String[] values = { "abc" };
        Queue<Object> q = makeQueue();

        // invoke
        q.enqueue(values[0]);

        // analyze
        assertEquals(1, q.size());
        assertEquals(values[0], q.dequeue());
        assertEquals(0, q.size());
    }

    @Test
    public void enqueueAndDequeue() {
        // setup
        String[] values = { "abc", "def", "ghi" };
        Queue<Object> q = makeQueue();

        // invoke
        q.enqueue(values[0]);
        q.enqueue(values[1]);
        q.enqueue(values[2]);

        // analyze
        assertEquals(3, q.size());
        assertEquals(values[0], q.dequeue());
        assertEquals(2, q.size());
        assertEquals(values[1], q.dequeue());
        assertEquals(1, q.size());
        assertEquals(values[2], q.dequeue());
        assertEquals(0, q.size());
    }
}

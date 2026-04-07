package unit07.practicum.priorityqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HeapPQTest {
    @Test
    public void create() {
        // setup - none

        // invoke
        Queue<Integer> q = new HeapPQ();

        // analyze
        assertEquals(0, q.size());
    }

    @Test
    public void enqueueOne() {
        // setup
        Queue<Integer> q = new HeapPQ();

        // invoke
        q.enqueue(123);

        // analyze
        assertEquals(1, q.size());
        assertEquals(123, q.dequeue());
        assertEquals(0, q.size());
    }

    @Test
    public void enqueueMany() {
        // setup
        Queue<Integer> q = new HeapPQ();

        // invoke
        q.enqueue(789);
        q.enqueue(123);
        q.enqueue(456);

        // analyze
        assertEquals(3, q.size());
        assertEquals(123, q.dequeue());
        assertEquals(2, q.size());
        assertEquals(456, q.dequeue());
        assertEquals(1, q.size());
        assertEquals(789, q.dequeue());
        assertEquals(0, q.size());
    }
}

package unit05;

/**
 * QueueTest for ArrayQueue.
 */
public class ArrayQueueTest extends QueueTest {
    @Override
    public Queue<Object> makeQueue() {
        // returns a new ArrayQueue to be tested
        return new ArrayQueue<Object>();
    }
}

package unit05;

/**
 * QueueTest for NodeQueue.
 */
public class NodeQueueTest extends QueueTest {
    @Override
    public Queue<Object> makeQueue() {
        // returns a new NodeQueue to be tested
        return new NodeQueue<Object>();
    }
}

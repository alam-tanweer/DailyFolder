package unit05;

/**
 * A node-based iplementation of a queue.
 */
public class NodeQueue<T> implements Queue<T> {
    /**
     * The node at the front of the queue.
     */
    private Node<T> front;

    /**
     * the node at the back of the queue.
     */
    private Node<T> back;

    /**
     * A count of the elements (nodes) in the queue.
     */
    private int size;

    /**
     * Creates a new, empty queue.
     */
    public NodeQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        Node<T> node = new Node<>(value);
        if (front == null) {
            front = node;
            back = node;
        } else {
            back.setNext(node);
            back = node;
        }
        size += 1;
    }

    @Override
    public T dequeue() {
        T value = front.getValue();
        front = front.getNext();
        if (front == null) {
            back = null;
        }
        size -= 1;
        return value;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "Queue{" + this.size() + ", " + this.front + "}";
    }

    public static void main(String[] args) {
        NodeQueue<String> q = new NodeQueue<String>();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        System.out.println(q);
        while(q.size>0) System.out.println(q.dequeue());
    }
}

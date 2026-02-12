package unit05.mcf;

//5.5
public class NodeQueue implements Queue {

    private Node front;
    private Node back;
    private int size;

    public NodeQueue(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(String value) {
        Node node = new Node(value);
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
    public String dequeue() {
        String value = front.getValue();
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
        NodeQueue q = new NodeQueue();
        q.enqueue("1");
        q.enqueue("2");
        q.enqueue("3");
        System.out.println(q);
        while(q.size>0) System.out.println(q.dequeue());
    }    
}

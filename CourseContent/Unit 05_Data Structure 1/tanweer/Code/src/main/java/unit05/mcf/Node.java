package unit05.mcf;

//5.3
public class Node {

    private String value;
    private Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(String value) {
        this(value, null);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public String toString(){
        String rest = this.next == null ? "null" : this.next.toString();
        return this.getValue() + " -> " + rest;
    }

    public static void main(String[] args) {
        // Node node1 = new Node("Node 1");
        // Node node2 = new Node("Node 2", node1);
        // Node node3 = new Node("Node 3", node2);
        // System.out.println(node3);

        Node node1 = new Node("Node 1");
        Node node2 = new Node("Node 2");
        node1.setNext(node2);
        Node node3 = new Node("Node 3");        
        node2.setNext(node3);

        System.out.println(node1);        
    }

}

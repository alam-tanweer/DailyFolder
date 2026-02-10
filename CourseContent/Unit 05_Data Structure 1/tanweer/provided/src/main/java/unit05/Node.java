package unit05;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this(value, null);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public String toString(){
        String rest = this.next == null ? "null" : this.next.toString();
        return this.getValue() + " -> " + rest;
    }

    public static void main(String[] args) {
        Node<String> node1 = new Node<String>("Node 1");
        Node<String> node2 = new Node<String>("Node 2", node1);
        Node<String> node3 = new Node<String>("Node 3", node2);
        System.out.println(node3);
    }
}

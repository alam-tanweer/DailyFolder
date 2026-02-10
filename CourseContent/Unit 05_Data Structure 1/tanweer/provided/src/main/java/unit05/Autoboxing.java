package unit05;

public class Autoboxing {
    public static void main(String[] args) {
        Queue<Integer> intQueue = new NodeQueue<>();

        intQueue.enqueue(123);

        // new Integer(123);

        int value = intQueue.dequeue();
        System.out.println(value);

        java.util.Queue<Integer> q = new java.util.LinkedList<>();
        System.out.println(q.poll());
    }
    
}

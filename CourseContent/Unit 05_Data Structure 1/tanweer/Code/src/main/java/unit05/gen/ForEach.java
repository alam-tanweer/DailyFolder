package unit05.gen;

public class ForEach {
    public static void main(String[] args) {
        NodeQueue<String> queue = new NodeQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        for (String string : queue) {
            System.out.println(string);
        }
    }
}

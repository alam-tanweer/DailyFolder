package unit06.practicum;


public class JCFStack {
    public static void main(String[] args) {
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (int n : stack) {
            System.out.println(n);
        }
    }
    
}

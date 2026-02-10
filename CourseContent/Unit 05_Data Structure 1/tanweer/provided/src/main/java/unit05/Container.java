package unit05;

import java.util.Arrays;

public class Container<T> {
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Container<String> c = new Container<>("abc");

        String value = c.getValue();
        // c.setValue(123);
        System.out.println(value);

        int[] orig = {1, 2};
        int[] copy = Arrays.copyOf(orig, 4);
        System.out.println(Arrays.toString(copy));
    }
}

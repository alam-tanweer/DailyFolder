package unit05;

public class Warehouse<T> {
    private Container<T> container;

    public Warehouse(T value) {
        container = new Container<>(value);
    }

    public Container<T> getContainer() {
        return container;
    }

    @SuppressWarnings("unchecked")
    public void doThings(T value) {
        // T[] things = new T[10]; // compiler error
        Object[] things = new Object[10];
        things[0] = value;

        Object obj = things[5];
        T thing = (T)obj;
        System.out.println(thing);
    }

    public static void main(String[] args) {
        Warehouse<String> wh = new Warehouse<>("abc");
        Container<String> c = wh.getContainer();
        String value = c.getValue();
        System.out.println(value);
    }
}

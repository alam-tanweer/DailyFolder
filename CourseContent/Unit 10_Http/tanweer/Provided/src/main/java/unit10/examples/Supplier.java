package unit10.examples;

public interface Supplier<T> {
    T get ();

    class MyClass {
        public String toString () {
            return "My class string";
        }
    }

    public static void main (String[] args) {
        Supplier<MyClass> myClass = ()-> new MyClass();
        MyClass instance = myClass.get();
        System.out.println (instance);
    }
}

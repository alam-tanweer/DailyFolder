package unit05;

public class Container2<T extends SomeClass> implements Box<T>{
    private T value;

    // public T getValue() {
    //     return value;
    // }

    public Container2(T value) {
        this.value = value;
    }

    public T getContent(){
        return value;
    }

    public static void main(String[] args) {
        Container2<SomeClass> c = new Container2<>(new SomeClass());
        // Container2<Integer> i = new Container2<>(123);

        System.out.println(c.getContent());
        // System.out.println(i.getContent() + 1);
    }
    
}

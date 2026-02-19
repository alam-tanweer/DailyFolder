package unit05;

import java.util.List;

// public class Container<T,K,alsdk> implements Box<T>{
// public class Container<T,K> implements Box<T>,Ship<K>{    

public class Container<T> implements Box<T>,Ship<String>{

    private T value;
    private List<T> listValues;
    
    // When using other Generic type
    private List<String> stringTypeValues;
    
    // public T getValue() {
    //     return value;
    // }

    public Container(T value) {
        this.value = value;
        // T[] abc = new T[]{};
    }

    public T getContent(){
        return value;
    }

    // public void ship(K value){
    //     System.out.println("Shipping : ");
    // }

    public void ship(String value){
        System.out.println("Shipping : ");
    }
    public static void main(String[] args) {
        // Container<String,String> c = new Container<>("ABC");
        // Container<Integer,String> i = new Container<>(123);
 
        Container<String> c = new Container<>("ABC");
        Container<Integer> i = new Container<>(123);

        System.out.println(c.getContent());
        System.out.println(i.getContent() + 1);
        c.ship("Abc");
    }
    
    class Pair<K, V, ABC, XYZ> {
        K key;
        V value;
    }

}

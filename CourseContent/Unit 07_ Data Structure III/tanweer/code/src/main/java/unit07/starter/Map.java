package unit07.starter;

public interface Map<K, V>{

    boolean add(K key, V value);
    boolean containsKey(K key);
    V remove(K key);
    V get(K key);
    int size();
    boolean isEmpty();
}

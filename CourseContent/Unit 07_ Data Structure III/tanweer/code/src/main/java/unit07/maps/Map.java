package unit07.maps;

// Iterable implementation is activity 7.14
public interface Map<K, V> extends Iterable<K> {

    boolean add(K key, V value);
    boolean containsKey(K key);
    V remove(K key);
    V get(K key);
    int size();
    boolean isEmpty();
}

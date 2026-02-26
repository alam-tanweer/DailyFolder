package unit07.maps;

/**
 * A simple map interface that associates keys of type K with values of type V.
 * Implementations should provide basic map operations including insertion,
 * lookup, removal and iteration over keys.
 *
 * @param <K> the key type
 * @param <V> the value type
 */
public interface Map<K, V> extends Iterable<K> {

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the behavior is
     * implementation dependent (e.g., overwrite or reject). Returns true if
     * the map changed as a result of the call.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return true if the map changed as a result of the call
     */
    boolean add(K key, V value);

    /**
     * Returns true if this map contains a mapping for the specified key.
     *
     * @param key key whose presence in this map is to be tested
     * @return true if this map contains a mapping for the specified key
     */
    boolean containsKey(K key);

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping
     */
    V remove(K key);

    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if none
     */
    V get(K key);

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map
     */
    int size();

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map contains no key-value mappings
     */
    boolean isEmpty();
}

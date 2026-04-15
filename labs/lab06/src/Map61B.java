import java.util.Set;

/**
 * Map61B interface:
 * An associative container that maps unique keys to values.
 * Any key must appear at most once in the map,
 * but values may appear multiple times.
 *
 * @param <K> the type of keys stored in this map
 * @param <V> the type of values stored in this map
 *
 * @author CS61B staff + SingularWind
 */
public interface Map61B<K, V> extends Iterable<K> {
    /**
     * Associates the specified value with the specified key in this map.
     * If the map already contains the specified key,
     * replaces the key's mapping with the value specified.
     *
     * @param key key to put value for
     * @param value value to put for the key
     */
    void put(K key, V value);

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key key to get value for
     * @return value mapped to the key, or null if no such mapping exists
     */
    V get(K key);

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key to remove mapping for
     * @return value mapped to the key, or null if no such mapping exists
     */
    V remove(K key);

    /**
     * Returns whether this map contains a mapping for the specified key.
     *
     * @param key key to check for
     * @return true if this map contains a mapping for the specified key,
     * false otherwise
     */
    boolean containsKey(K key);

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return number of key-value mappings in this map
     */
    int size();

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map is empty
     */
    boolean isEmpty();

    /**
     * Removes all the mapping from this map.
     */
    void clear();

    /**
     * Returns a Set view of the keys contained in this map.
     *
     * @return Set view of the keys contained in this map
     */
    Set<K> keySet();
}

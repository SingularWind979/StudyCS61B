import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * A data structure that uses a binary search tree to store pairs of keys and values.
 * Any key must appear at most once in the dictionary,
 * but values may appear multiple times.
 * The value associated to a key is the value in the last call to put with that key.
 *
 * @param <K> the type of keys stored in this dictionary
 * @param <V> the type of values stored in this dictionary
 *
 * @author SingularWind
 */
public class BSTMap<K, V> implements Map61B<K, V> {
    /**
     * Associates the specified value with the specified key in this map.
     * If the map already contains the specified key,
     * replaces the key's mapping with the value specified.
     *
     * @param key   key to put value for
     * @param value value to put for the key
     */
    @Override
    public void put(K key, V value) {

    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key key to get value for
     * @return value mapped to the key, or null if no such mapping exists
     */
    @Override
    public V get(K key) {
        return null;
    }

    /**
     * Returns whether this map contains a mapping for the specified key.
     *
     * @param key key to check for
     * @return true if this map contains a mapping for the specified key,
     * false otherwise
     */
    @Override
    public boolean containsKey(K key) {
        return false;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return number of key-value mappings in this map
     */
    @Override
    public int size() {
        return 0;
    }

    /**
     * Removes every mapping from this map.
     */
    @Override
    public void clear() {

    }

    /**
     * Returns a Set view of the keys contained in this map.
     *
     * @return Set view of the keys contained in this map
     * @throws UnsupportedOperationException if you don't implement this
     */
    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key to remove mapping for
     * @return value mapped to the key, or null if no such mapping exists
     * @throws UnsupportedOperationException if you don't implement this
     */
    @Override
    public V remove(K key) {
        return null;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<K> iterator() {
        return new BSTMapIterator();
    }

    private class BSTMapIterator implements Iterator<K> {
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public K next() {
            return null;
        }
    }
}

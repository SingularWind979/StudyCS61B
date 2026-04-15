import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * BSTMap implementation:
 * A binary search tree based map implementation.
 * Any key must appear at most once in the map,
 * but values may appear multiple times.
 *
 * @param <K> the type of keys stored in this map,
 * must be {@link Comparable}
 * @param <V> the type of values stored in this map
 *
 * @author SingularWind
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    OrderedTree<Entry<K, V>> tree;        // the underlying ordered tree

    /**
     * Constructs a new BSTMap.
     */
    public BSTMap() {
        this.tree = new BST<>();
    }

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
        Entry<K, V> putted = tree.find(new Entry<>(key, null));
        if (putted != null) {
            putted.value = value;
        } else {
            putted = new Entry<>(key, value);
            tree.insert(putted);
        }
    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key key to get value for
     * @return value mapped to the key, or null if no such mapping exists
     */
    @Override
    public V get(K key) {
        Entry<K, V> find = tree.find(new Entry<>(key, null));
        return find != null ? find.value : null;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key key to remove mapping for
     * @return value mapped to the key, or null if no such mapping exists
     */
    @Override
    public V remove(K key) {
        Entry<K, V> found = tree.find(new Entry<>(key, null));
        if (found == null) {
            return null;
        }
        Entry<K, V> removed = tree.delete(found);
        return removed != null ? removed.value : null;
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
        Entry<K, V> find = tree.find(new Entry<>(key, null));
        return find != null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return number of key-value mappings in this map
     */
    @Override
    public int size() {
        return tree.size();
    }

    /**
     * Returns whether this map is empty.
     *
     * @return true if this map is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * Removes all the mapping from this map.
     */
    @Override
    public void clear() {
        tree.clear();
    }

    /**
     * Returns a Set view of the keys contained in this map.
     *
     * @return Set view of the keys contained in this map
     */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new TreeSet<>();
        for (Entry<K, V> entry : tree) {
            keys.add(entry.key);
        }
        return keys;
    }

    /**
     * Returns an iterator over elements of type {@code K} in this map.
     *
     * @return an Iterator over elements of type {@code K} in this map
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<K> iterator() {
        return keySet().iterator();
    }

    /**
     * Entry class for the map.
     *
     * @param <K> the type of keys stored in this map
     * @param <V> the type of values stored in this map
     */
    private static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
        final K key;        // key of the entry, immutable
        V value;            // value of the entry

        /**
         * Constructs a new entry with the specified key and value.
         *
         * @param key   key to put value for
         * @param value value to put for the key
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Compares this entry with the specified entry for order by comparing key.
         *
         * @param o the entry to compare with
         * @return a negative integer, zero, or a positive integer
         * as this entry is less than, equal to, or greater than the specified entry
         */
        @Override
        public int compareTo(Entry<K, V> o) {
            return this.key.compareTo(o.key);
        }
    }
}

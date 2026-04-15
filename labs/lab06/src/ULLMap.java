import java.util.Iterator;
import java.util.Set;

/**
 * ULLMap implementation:
 * A linked list based map implementation.
 * Any key must appear at most once in the map,
 * but values may appear multiple times.
 *
 * @param <K> the type of keys stored in this map
 * @param <V> the type of values stored in this map
 *
 * @author CS61B staff + SingularWind
 */
public class ULLMap<K, V> implements Map61B<K, V> {
    /** Keys and values are stored in a linked list. */
    private Node first;
    /** The number of key-value mappings in this map. */
    private int size = 0;

    /**
     * Associates the specified value with the specified key in this map.
     * If the map already contains the specified key,
     * replaces the key's mapping with the value specified.
     *
     * @param k key to put value for
     * @param v value to put for the key
     */
    @Override
    public void put(K k, V v) {
        if (first != null) {
            Node lookup = first.get(k);
            if (lookup == null) {
                first = new Node(k, v, first);
            } else {
                lookup.value = v;
            }
        } else {
            first = new Node(k, v, null);
            size = size + 1;
        }
    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param k key to get value for
     * @return value mapped to the key, or null if no such mapping exists
     */
    @Override
    public V get(K k) {
        if (first == null) {
            return null;
        }
        Node lookup = first.get(k);
        if (lookup == null) {
            return null;
        }
        return lookup.value;
    }

    /**
     * Returns whether this map contains a mapping for the specified key.
     *
     * @param k key to check for
     * @return true if this map contains a mapping for the specified key,
     * false otherwise
     */
    @Override
    public boolean containsKey(K k) {
        if (first == null) {
            return false;
        }
        return first.get(k) != null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this map contains no key-value mappings.
     *
     * @return true if this map is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all the mapping from this map.
     */
    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    /**
     * Returns a Set view of the keys contained in this map.
     *
     * @return Set view of the keys contained in this map
     * @throws UnsupportedOperationException if you don't implement this
     */
    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param k key to remove mapping for
     * @return value mapped to the key, or null if no such mapping exists
     * @throws UnsupportedOperationException if you don't implement this
     */
    @Override
    public V remove(K k) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an iterator over the keys of this map.
     *
     * @return an iterator over the keys of this map
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<K> iterator() {
        return new ULLMapIter();
    }

    /**
     * Represents one node in the linked list
     * that stores the key-value pairs in the ULLMap.
     */
    private class Node {
        /** Stores the key of the key-value pair of this node. */
        K key;
        /** Stores the value of the key-value pair of this node. */
        V value;
        /** Stores the next Node in the linked list. */
        Node next;

        /**
         * Creates a new Node in the linked list.
         *
         * @param k key of the key-value pair of this node
         * @param v value of the key-value pair of this node
         * @param n next Node in the linked list
         */
        Node(K k, V v, Node n) {
            this.key = k;
            this.value = v;
            this.next = n;
        }

        /**
         * Returns the Node whose key is equal to {@code k},
         * or null if no such Node exists.
         *
         * @param k key to get value for
         * @return Node whose key is equal to {@code k},
         * or null if no such Node exists
         */
        Node get(K k) {
            if (k != null && k.equals(key)) {
                return this;
            }
            if (next == null) {
                return null;
            }
            return next.get(k);
        }
    }

    /**
     * An iterator
     * that iterates over the keys of the ULLMap.
     */
    private class ULLMapIter implements Iterator<K> {
        /** Stores the current key-value pair. */
        private Node current;

        /**
         * Creates a new ULLMapIter
         * by setting current to the first Node
         * in the linked list.
         */
        public ULLMapIter() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public K next() {
            K nextKey = current.key;
            current = current.next;
            return nextKey;
        }
    }
}

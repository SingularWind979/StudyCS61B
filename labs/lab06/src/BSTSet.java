import java.util.Iterator;

/**
 * BSTSet class:
 * A binary search tree based set implementation.
 * A collection that contains no duplicate elements.
 *
 * @param <K> the type of elements maintained by this set,
 * must be {@link Comparable}
 *
 * @author SingularWind
 */
public class BSTSet<K extends Comparable<K>> implements Set61B<K> {
    OrderedTree<K> tree;        // the underlying ordered tree

    /**
     * Constructs a new empty set.
     */
    public BSTSet() {
        tree = new BST<>();
    }

    /**
     * Inserts the specified element into this set if it is not already present.
     * If this set already contains the element, the call leaves the set
     * unchanged and does not increase the size.
     *
     * @param key element to be inserted into this set
     * @return the reference to the inserted element
     * @throws IllegalArgumentException if the key is null
     */
    @Override
    public K insert(K key) {
        return tree.insert(key);
    }

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param key element to be removed from this set, if present
     * @return the reference to the deleted element, or null if no such element exists
     */
    @Override
    public K delete(K key) {
        return tree.delete(key);
    }

    /**
     * Returns true if this set contains the specified element.
     *
     * @param key element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    @Override
    public boolean contains(K key) {
        return tree.contains(key);
    }

    /**
     * Returns the number of elements in this set (its cardinality).
     *
     * @return the number of elements in this set
     */
    @Override
    public int size() {
        return tree.size();
    }

    /**
     * Returns true if this set contains no elements.
     *
     * @return true if this set is empty
     */
    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    /**
     * Removes all the keys from this set.
     * The set will be empty after this call returns.
     */
    @Override
    public void clear() {
        tree.clear();
    }

    /**
     * Returns an iterator over elements of type {@code K} in this set.
     *
     * @return an Iterator over elements of type {@code K} in this set
     */
    @Override
    @SuppressWarnings("NullableProblems")
    public Iterator<K> iterator() {
        return tree.iterator();
    }
}

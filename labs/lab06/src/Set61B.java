/**
 * Set61B interface:
 * A collection that contains no duplicate elements.
 *
 * @param <K> the type of elements maintained by this set
 *
 * @author SingularWinid
 */
public interface Set61B<K> extends Iterable<K> {
    /**
     * Inserts the specified element into this set if it is not already present.
     * If this set already contains the element, the call leaves the set
     * unchanged and does not increase the size.
     *
     * @param key element to be inserted into this set
     * @throws IllegalArgumentException if the key is null
     */
    boolean insert(K key);

    /**
     * Removes the specified element from this set if it is present.
     *
     * @param key element to be removed from this set, if present
     */
    boolean delete(K key);

    /**
     * Returns true if this set contains the specified element.
     *
     * @param key element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    boolean contains(K key);

    /**
     * Returns the number of elements in this set (its cardinality).
     *
     * @return the number of elements in this set
     */
    int size();

    /**
     * Returns true if this set contains no elements.
     *
     * @return true if this set is empty
     */
    boolean isEmpty();

    /**
     * Removes all the keys from this set.
     * The set will be empty after this call returns.
     */
    void clear();
}

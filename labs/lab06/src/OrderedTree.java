import java.util.Iterator;

/**
 * OrderedTree interface:
 * A tree data structure that maintains elements in a specific order.
 *
 * @param <K> the type of elements maintained by this ordered tree,
 * must be {@link Comparable}
 *
 * @author SingularWind
 */
public interface OrderedTree<K extends Comparable<K>> extends Iterable<K> {
    /**
     * Inserts the specified key into this ordered tree.
     *
     * @param key the key to insert
     * @return true if the key was successfully inserted, false otherwise
     */
    boolean insert(K key);

    /**
     * Deletes the specified key from this ordered tree.
     *
     * @param key the key to delete
     * @return true if the key was successfully deleted, false otherwise
     */
    boolean delete(K key);

    /**
     * Returns whether this ordered tree contains the specified key.
     *
     * @param key the key to check for
     * @return true if this ordered tree contains the specified key,
     * false otherwise
     */
    boolean contains(K key);

    /**
     * Returns the number of keys in this ordered tree.
     *
     * @return the number of keys in this ordered tree
     */
    int size();

    /**
     * Returns whether this ordered tree is empty.
     *
     * @return true if this ordered tree is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Removes all items from this ordered tree.
     */
    void clear();

    /**
     * Returns an iterator over the items in this ordered tree in inorder.
     *
     * @return an iterator over the items in this ordered tree in inorder
     */
    Iterator<K> inorderIterator();
}

import java.util.List;

/**
 * A set of items of type T.
 *
 * @param <T> the type of items in the set
 * @author SingularWind
 */
public interface MySet<T> extends Iterable<T> {
    /**
     * Adds item to this set if it is not already present.
     *
     * @param item the item to be added to this set
     */
    void add(T item);

    /**
     * Removes item from this set if it is present.
     *
     * @param item the item to be removed from this set
     */
    void remove(T item);

    /**
     * Returns true if this set contains item, false otherwise.
     *
     * @param item the item to be checked for presence in this set
     * @return true if this set contains item, false otherwise
     */
    boolean contains(T item);

    /**
     * Returns the number of items in this set.
     *
     * @return the number of items in this set
     */
    int size();

    /**
     * Returns true if this set is empty, false otherwise.
     *
     * @return true if this set is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns a list of all items in this set, in the order they were added.
     *
     * @return a list of all items in this set, in the order they were added
     */
    List<T> toList();
}

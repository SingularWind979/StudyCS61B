/**
 * A list of items of type T.
 *
 * @param <T> the type of items in the list
 * @author SingularWind
 */
public interface MyList<T> {
    /**
     * Returns the number of items in the list.
     *
     * @return the number of items in the list
     */
    int size();

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns the item at the given index.
     *
     * @param index the index of the item to return
     * @return the item at the given index
     */
    T get(int index);

    /**
     * Inserts the given item at the given index.
     *
     * @param item the item to insert
     * @param index the index at which to insert the item
     */
    void insert(T item, int index);

    /**
     * Removes and returns the item at the given index.
     *
     * @param index the index of the item to remove
     * @return the item at the given index
     */
    T remove(int index);

    /**
     * Returns the first item in the list.
     *
     * @return the first item in the list
     */
    T getFirst();

    /**
     * Returns the last item in the list.
     *
     * @return the last item in the list
     */
    T getLast();

    /**
     * Adds the given item to the front of the list.
     *
     * @param item the item to add
     */
    void addFirst(T item);

    /**
     * Adds the given item to the end of the list.
     *
     * @param item the item to add
     */
    void addLast(T item);

    /**
     * Removes and returns the first item in the list.
     *
     * @return the first item in the list
     */
    T removeFirst();

    /**
     * Removes and returns the last item in the list.
     *
     * @return the last item in the list
     */
    T removeLast();
}

/**
 * Self-defined interface for a list data structure.
 *
 * @param <T> Type of elements in the list
 * @author Singularwind
 */
public interface MyList<T> {
    /**
     * Add an item to the front of the list.
     *
     * @param item the item to add
     */
    public void addFirst(T item);

    /**
     * Add an item to the end of the list.
     *
     * @param item the item to add
     */
    public void addLast(T item);

    /**
     * Retrieves the first item in the list.
     *
     * @return the first item
     */
    public T getFirst();

    /**
     * Retrieves the last item of the list.
     *
     * @return the last item
     */
    public T getLast();

    /**
     * Removes and returns the first item of the list.
     *
     * @return the removed item
     */
    public T removeFirst();

    /**
     * Removes and returns the last item of the list.
     *
     * @return the removed item
     */
    public T removeLast();

    /**
     * Retrieves the {@code index}th item of the list.
     *
     * @param index the index of the item you want
     * @return the {@code index}th item
     */
    public T get(int index);

    /**
     * Inserts an item at the specified index.
     *
     * @param item the item to insert
     * @param index the position to insert
     * @return the inserted item
     */
    public T insert(T item, int index);

    /**
     *  Returns the size of the list (number of items).
     *
     * @return the size of the list
     */
    public int size();

    /**
     * Print the items of the list.
     */
    public void print();
}

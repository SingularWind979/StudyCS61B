/**
 * A singly-linked list implementation with a sentinel that supports rotation operations.
 * @param <T> the type of elements stored in the list
 *
 * @author SingularWind
 */
public class VengefulSLList<T> extends SLList<T> {
    private final SLList<T> removedItems = new SLList<>();

    /**
     * Removes and returns the item at the given index.
     *
     * @param index the index of the item to remove
     * @return the item at the given index
     */
    @Override
    public T remove(int index) {
        T removed = super.remove(index);
        removedItems.addLast(removed);
        return removed;
    }

    /**
     * Removes and returns the first item in the list.
     *
     * @return the first item in the list
     */
    @Override
    public T removeFirst() {
        T removed = super.removeFirst();
        removedItems.addLast(removed);
        return removed;
    }

    /**
     * Removes and returns the last item in the list.
     *
     * @return the last item in the list
     */
    @Override
    public T removeLast() {
        T removed = super.removeLast();
        removedItems.addLast(removed);
        return removed;
    }

    /**
     * Returns the items in the removedItems list.
     *
     * @return the items in the removedItems list
     */
    public SLList<T> RemovedItems() {
        return removedItems;
    }
}

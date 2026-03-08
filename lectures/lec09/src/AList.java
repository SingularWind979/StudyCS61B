/**
 * AList is a resizable array implementation of the List interface.
 * @param <T> the type of elements in this list
 *
 * @author SingularWind
 */
@SuppressWarnings("unchecked")
public class AList<T> extends AbstractList<T> {
    private static final int INIT_CAPACITY = 100;
    private static final int RESIZE_FACTOR = 2;
    private static final double MIN_USAGE_RATIO = 1.0 / RESIZE_FACTOR / RESIZE_FACTOR;

    private T[] items;  // array to store the elements in this list

    /**
     * Constructs an empty AList with the default capacity.
     */
    public AList() {
        items = (T[]) new Object[INIT_CAPACITY];
    }


    /**
     * Returns the item at the given index.
     *
     * @param index the index of the item to return
     * @return the item at the given index
     */
    @Override
    public T get(int index) {
        // check if the list is empty
        checkEmptyList();
        // check if index is valid
        checkIndex(index);

        // return the item at the given index
        return items[index];
    }

    /**
     * Inserts the given item at the given index.
     *
     * @param item  the item to insert
     * @param index the index at which to insert the item
     */
    @Override
    public void insert(T item, int index) {
        // insert can be at the end, which is out of index
        if (index == size) {
            addLast(item);
            return;
        }

        // check if index is valid
        checkIndex(index);

        // resize if necessary
        if (isFull()) {
            resize(items.length * RESIZE_FACTOR);
        }

        // insert the item at the given index
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
    }

    /**
     * Removes and returns the item at the given index.
     *
     * @param index the index of the item to remove
     * @return the item at the given index
     */
    @Override
    public T remove(int index) {
        // check if the list is empty
        checkEmptyList();
        // check if index is valid
        checkIndex(index);

        // remove the item at the given index
        T removed = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[size - 1] = null;
        size--;

        // resize if necessary
        if (usageRatio() < MIN_USAGE_RATIO && items.length > INIT_CAPACITY) {
            resize(items.length / RESIZE_FACTOR);
        }

        // return the removed item
        return removed;
    }

    /**
     * Returns the first item in the list.
     *
     * @return the first item in the list
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    @Override
    public T getLast() {
        return get(size - 1);
    }

    /**
     * Adds the given item to the front of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addFirst(T item) {
        insert(item, 0);
    }

    /**
     * Appends the specified element to the end of this list.
     * @param item the element to be appended to this list
     */
    @Override
    public void addLast(T item) {
        // resize if necessary
        if (isFull()) {
            resize(items.length * RESIZE_FACTOR);
        }

        items[size++] = item;
    }

    /**
     * Removes and returns the first item in the list.
     *
     * @return the first item in the list
     */
    @Override
    public T removeFirst() {
        return remove(0);
    }

    /**
     * Removes the last element from this list.
     *
     * @return the last element from this list
     */
    @Override
    public T removeLast() {
        // check if the list is empty
        checkEmptyList();

        // remove the last item
        T last = items[size - 1];
        items[size - 1] = null;
        size--;

        // resize if necessary
        if (usageRatio() < MIN_USAGE_RATIO && items.length > INIT_CAPACITY) {
            resize(items.length / RESIZE_FACTOR);
        }

        // return the last item
        return last;
    }

    /**
     * Returns the usage ratio of this list.
     *
     * @return the usage ratio of this list
     */
    private double usageRatio() {
        return (double) size / items.length;
    }

    /**
     * Resizes the internal array to the specified new capacity.
     *
     * @param newCapacity the new capacity of the internal array
     */
    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    /**
     * Returns true if this list is full.
     *
     * @return true if this list is full
     */
    private boolean isFull() {
        return size == items.length;
    }

    /**
     * Returns the connector character used in the string representation of this list.
     *
     * @return the connector character used in the string representation of this list
     */
    @Override
    protected String connector() {
        return ", ";
    }
}

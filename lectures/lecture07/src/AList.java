/**
 * Name: AList (Array List).
 * Topology: array-based
 *
 * @param <T> Type of elements in the list
 * @author Singularwind
 */

public class AList<T> implements MyList<T> {
    // array that stores items
    private T[] items;
    // the capacity of items, capacity = items.length
    private int capacity;
    // numbers of the actual items, 0 <= size <= capacity - 1
    private int size;
    // initial capacity of the array
    private final int INITIAL_CAPACITY = 10;
    // capacity grows or shrinks by this constant factor
    private final int RESIZE_FACTOR = 2;
    // shrink the array when size / capacity falls below this ratio
    private final double MIN_USAGE_RATIO = 0.25;

    /** constructor of an empty list */
    public AList() {
        capacity = INITIAL_CAPACITY;
        items = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * Resize the list to the new capacity,
     * create a new array and copy items over.
     * @param newCapacity the new capacity of the list
     */
    private void resize(int newCapacity) {
        if (newCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + newCapacity);
        }
        T[] newItems = (T[]) new Object[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        capacity = newCapacity;
    }

    /**
     * Judge if the list is empty.
     * @return true if the list has no item
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * Judge if the list is full
     * @return true if no more items can be added without resizing
     */
    private boolean isFull() {
        return size == capacity;
    }

    /**
     * Add an item to the front of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addFirst(T item) {

    }

    /**
     * Add an item to the end of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(size * RESIZE_FACTOR);
        }
        items[size++] = item;
    }

    /**
     * Retrieves the first item in the list.
     *
     * @return the first item
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * Retrieves the last item of the list.
     *
     * @return the last item
     */
    @Override
    public T getLast() {
        return get(size - 1);
    }

    /**
     * Removes and returns the first item of the list.
     *
     * @return the removed item
     */
    @Override
    public T removeFirst() {
        return null;
    }

    /**
     * Removes and returns the first item of the list.
     *
     * @return the removed item
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Empty List");
        }
        T last = getLast();
        items[--size] = null;
        if ((double) size / capacity < MIN_USAGE_RATIO) {
            resize(size / RESIZE_FACTOR);
        }
        return last;
    }

    /**
     * Retrieves the {@code index}th item of the list.
     *
     * @param index the index of the item you want
     * @return the {@code index}th item
     */
    @Override
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return items[index];
    }

    /**
     * Inserts an item at the specified index.
     *
     * @param item  the item to insert
     * @param index the position to insert
     * @return the inserted item
     */
    @Override
    public T insert(T item, int index) {
        return null;
    }

    /**
     * Returns the size of the list (number of items).
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }
}

/**
 * AList is a resizable array implementation of the List interface.
 * @param <T> the type of elements in this list
 *
 * @author SingularWind
 */
@SuppressWarnings("unchecked")
public class AList<T> {
    private static final int INIT_CAPACITY = 100;
    private static final int RESIZE_FACTOR = 2;
    private static final double MIN_USAGE_RATIO = 1.0 / RESIZE_FACTOR / RESIZE_FACTOR;

    private T[] items;  // array to store the elements in this list
    private int size;   // number of elements in this list

    /**
     * Constructs an empty AList with the default capacity.
     */
    public AList() {
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns true if this list is full.
     *
     * @return true if this list is full
     */
    public boolean isFull() {
        return size == items.length;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     */
    public T getLast() {
        return items[size - 1];
    }

    /**
     * Appends the specified element to the end of this list.
     * @param item the element to be appended to this list
     */
    public void addLast(T item) {
        if (isFull()) {
            resize(items.length * RESIZE_FACTOR);
        }
        items[size++] = item;
    }

    /**
     * Removes the last element from this list.
     *
     * @return the last element from this list
     */
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T last = items[size - 1];
        items[size - 1] = null;
        size--;
        if (usageRatio() < MIN_USAGE_RATIO && items.length > INIT_CAPACITY) {
            resize(items.length / RESIZE_FACTOR);
        }
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
}

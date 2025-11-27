/**
 * My implement of ArrayList
 * @author Singularwind
 */

public class AList<T> {
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
     * resize the list to the new capacity,
     * create a new array and copy items over
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
     * judge if the list is empty
     * @return true if the list has no items
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * judge if the list is full
     * @return true if no more items can be inserted without resizing
     */
    private boolean isFull() {
        return size == capacity;
    }

    /**
     * get the size of the list
     * @return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * get the {@code index}th item of the list
     * @param index {@code index} = {0, 1, 2, ..., size - 1}
     * @return the {@code index}th item
     */
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return items[index];
    }

    /**
     * get the first item of the list
     * @return the first item
     */
    public T getFirst() {
        return get(0);
    }

    /**
     * get the last item of the list
     * @return the last item
     */
    public T getLast() {
        return get(size - 1);
    }

    /**
     * add item to the last of the list
     * @param item the new added item
     */
    public void addLast(T item) {
        if (isFull()) {
            resize(size * RESIZE_FACTOR);
        }
        items[size++] = item;
    }

    /**
     * remove the last item and return it
     * @return the last item that has been removed
     */
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
}
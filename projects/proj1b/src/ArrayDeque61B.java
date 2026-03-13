import java.util.ArrayList;
import java.util.List;

/**
 * Represents an array deque implementation of a deque.
 *
 * @param <T> the type of items stored in the deque
 * @author SingularWind
 */
public class ArrayDeque61B<T> implements Deque61B<T> {
    /** The initial capacity of the deque. */
    private static final int INIT_CAPACITY = 8;

    /** The array that stores the items. */
    T[] items;
    /** The number of items in the deque. */
    int size;
    /**
     * Physical pos in the array
     * where the {@code addFirst} operation will insert the next item.
     * validify(nextFirst + 1) is the first item in the array.
     */
    int nextFirst;
    /**
     * Physical pos in the array
     * where the {@code addLast} operation will insert the next item.
     * validify(nextLast - 1) is the last item in the array.
     */
    int nextLast;

    /**
     * Constructs an empty ArrayDeque61B.
     */
    public ArrayDeque61B() {
        //noinspection unchecked
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast  = 1;
    }

    /**
     * Returns the element at the front of the deque,
     * if it exists.
     * Does not alter the deque.
     *
     * @return element at the front of the deque, otherwise {@code null}.
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * Returns the element at the back of the deque,
     * if it exists.
     * Does not alter the deque.
     *
     * @return element at the back of the deque, otherwise {@code null}.
     */
    @Override
    public T getLast() {
        return get(size - 1);
    }

    /**
     * Add {@code x} to the front of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // Add x to the front of the deque
        items[nextFirst] = x;
        size++;

        // Move nextFirst to the new position
        nextFirst = validify(nextFirst - 1);
    }

    /**
     * Add {@code x} to the back of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        // Add x to the back of the deque
        items[nextLast] = x;
        size++;

        // Move nextLast to the new position
        nextLast = validify(nextLast + 1);
    }

    /**
     * Returns a List copy of the deque.
     * Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(get(i));
        }

        return list;
    }

    /**
     * Returns if the deque is empty.
     * Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the deque.
     * Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Remove and return the element at the front of the deque,
     * if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        // Check if the deque is empty
        if (isEmpty()) {
            return null;
        }

        // Move nextFirst to the first position
        nextFirst = validify(nextFirst + 1);

        // Get the element at the first position
        T x = items[nextFirst];

        // Clear the old position
        items[nextFirst] = null;
        size--;

        return x;
    }

    /**
     * Remove and return the element at the back of the deque,
     * if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        // Check if the deque is empty
        if (isEmpty()) {
            return null;
        }

        // Move nextLast to the last position
        nextLast = validify(nextLast - 1);

        // Get the element at the last position
        T x = items[nextLast];

        // Clear the old position
        items[nextLast] = null;
        size--;

        return x;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation
     * to provide you with some extra programming practice.
     * Gets the element, iteratively.
     * Returns null if index is out of bounds.
     * Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return items[validify(nextFirst + 1 + index)];
    }

    /**
     * This method technically shouldn't be in the interface,
     * but it's here to make testing nice.
     * Gets an element, recursively.
     * Returns null if index is out of bounds.
     * Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T getRecursive(int index) {
        return null;
    }

    /**
     * Returns the capacity of the deque.
     *
     * @return the capacity of the deque
     */
    private int capacity() {
        return items.length;
    }

    /**
     * Returns a valid position in the array.
     *
     * @param pos position to validate
     * @return a valid position in the array
     */
    private int validify(int pos) {
        return Math.floorMod(pos, capacity());
    }
}

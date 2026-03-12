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
    /** The index of the next item to interact with from the front. */
    int nextFirst;
    /** The index of the next item to interact with from the back. */
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
        items[nextFirst--] = x;
        nextFirst = Math.floorMod(nextFirst, capacity());
        size++;
    }

    /**
     * Add {@code x} to the back of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        items[nextLast++] = x;
        nextLast = Math.floorMod(nextLast, capacity());
        size++;
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
        return null;
    }

    /**
     * Remove and return the element at the back of the deque,
     * if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        return null;
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

        return items[Math.floorMod(nextFirst + 1 + index, capacity())];
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
}

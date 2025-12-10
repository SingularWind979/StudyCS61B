import java.util.ArrayList;
import java.util.List;

/**
 * Circular Array Deque
 *
 * @author SingularWind
 * @param <T> the type of items in the deque
 */
public class ArrayDeque61B<T> implements Deque61BB<T> {
    /* class constants */
    public static final int INIT_CAPACITY = 8;  // the initial capacity
    public static final int RESIZE_FACTOR = 2;  // a geometric resize factor

    /* instance variables */
    private T[] items;      // backing array to store elements
    private int capacity;   // the current capacity (equals to items.length())
    private int size;       // the numbers of the really stored elements
    private int nextFirst;  // index of the next front element to add, starting from the middle
    private int nextLast;   // index of the next back  element to add, starting from the middle

    /* constructor */
    public ArrayDeque61B() {
        items = (T[]) new Object[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
        size = 0;
        nextFirst = capacity / 2;
        nextLast  = capacity / 2 + 1;
    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // TODO: array fills, which needs resizing
        items[nextFirst] = x;
        nextFirst = validifyIndex(nextFirst - 1);
        size++;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        // TODO: array fills, which needs resizing
        items[nextLast] = x;
        nextLast = validifyIndex(nextLast + 1);
        size++;
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        int first = validifyIndex(nextFirst + 1);
        for (int i = 0; i < size(); i++) {
            returnList.add(items[validifyIndex(first + i)]);
        }
        return returnList;
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        return null;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        return null;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        return null;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T getRecursive(int index) {
        return null;
    }


    /**
     * change index to valid index via floorMod
     *
     * @param index the original index, maybe negative
     * @return valid index of a circular array
     */
    private int validifyIndex(int index) {
        return Math.floorMod(index, capacity);
    }
}

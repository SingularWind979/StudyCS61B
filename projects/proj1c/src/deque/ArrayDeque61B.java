package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An array implementation of the Deque61B interface.
 *
 * @param <T> the type of items in the deque.
 * @author SingularWind
 * @version 2.0
 */
public class ArrayDeque61B<T> extends AbstractDeque61B<T> {
    /** The initial and minium capacity of the deque. */
    private static final int INIT_CAPACITY = 8;
    /** The geometric resize factor of the deque. */
    private static final int RESIZE_FACTOR = 2;

    /** The backing array of items in the deque. */
    private T[] items;

    /**
     * The array index of the next first item to be added in the backing array.
     * The array index of the actual first item is {@code validify(nextFirst + 1)}.
     */
    private int nextFirst;
    /**
     * The array index of the next last item to be added in the backing array.
     * The array index of the actual last item is {@code validify(nextLast - 1)}.
     */
    private int nextLast;

    /**
     * Initializes an empty deque
     * with the initial capacity of {@code INIT_CAPACITY}.
     */
    public ArrayDeque61B() {
        //noinspection unchecked
        items = (T[]) new Object[INIT_CAPACITY];
        nextFirst = 0;
        nextLast = 1;

        checkInvariants();
    }

    /**
     * Adds {@code x} to the front of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        checkInvariants();

        // resize if necessary before add item
        smartResize();

        // add to the front
        items[nextFirst] = x;
        nextFirst = validify(nextFirst - 1);
        size++;

        checkInvariants();
    }

    /**
     * Adds {@code x} to the back of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        checkInvariants();

        // resize if necessary before add item
        smartResize();

        // add to the back
        items[nextLast] = x;
        nextLast = validify(nextLast + 1);
        size++;

        checkInvariants();
    }

    /**
     * Removes and returns the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        checkInvariants();

        // check if empty
        if (isEmpty()) {
            return null;
        }

        // remove from the front
        nextFirst = validify(nextFirst + 1);
        T removedFirst = items[nextFirst];
        items[nextFirst] = null;
        size--;

        // resize if necessary after remove item
        smartResize();

        checkInvariants();

        // return the removed item
        return removedFirst;
    }

    /**
     * Removes and returns the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        checkInvariants();

        // check if empty
        if (isEmpty()) {
            return null;
        }

        // remove from the back
        nextLast = validify(nextLast - 1);
        T removedLast = items[nextLast];
        items[nextLast] = null;
        size--;

        // resize if necessary after remove item
        smartResize();

        checkInvariants();

        // return the removed item
        return removedLast;
    }

    /**
     * Returns the element at the front of the deque, if it exists.
     * Does not alter the deque.
     *
     * @return element at the front of the deque, if it exists, {@code null} otherwise.
     */
    @Override
    public T getFirst() {
        return get(0);
    }

    /**
     * Returns the element at the back of the deque, if it exists.
     * Does not alter the deque.
     *
     * @return element at the back of the deque, if it exists, {@code null} otherwise.
     */
    @Override
    public T getLast() {
        return get(size - 1);
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but it's here to provide you with some extra practice.
     * Gets the element, iteratively.
     * Returns null if index is out of bounds.
     * Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        return isValid(index)
                ? items[arrayIndexOf(index)]
                : null;
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
        throw new UnsupportedOperationException("ArrayDeque61B does not support recursive get.");
    }

    /**
     * Checks the invariants of the array deque implementation.
     */
    private void checkInvariants() {
        // check size
        assert size >= 0 && size <= capacity() : "size is out of bounds";

        // check nextFirst and nextLast are valid
        assert nextFirst == validify(nextFirst) : "nextFirst is out of bounds";
        assert nextLast  == validify(nextLast)  : "nextLast is out of bounds";

        // check items[nextFirst] and items[nextLast] are null to avoid loitering
        if (size < capacity()) {
            assert items[nextFirst] == null : "nextFirst is not null";
            assert items[nextLast]  == null : "nextLast is not null";
        }
    }

    /**
     * Returns the capacity of the deque.
     *
     * @return capacity
     */
    private int capacity() {
        return items.length;
    }

    /**
     * Returns if the index is valid.
     *
     * @param index index to check
     * @return {@code true} if the index is valid, {@code false} otherwise.
     */
    private boolean isValid(int index) {
        return index >= 0 && index < size;
    }

    /**
     * Returns the valid index of the deque.
     * If the index is out of bounds, returns the index of the deque.
     *
     * @param index index to validify
     * @return valid index
     */
    private int validify(int index) {
        return Math.floorMod(index, capacity());
    }

    /**
     * Returns the index of the element in the array.
     * If the index is out of bounds, returns the index of the deque.
     *
     * @param index index to get the array index
     * @return index in the array
     */
    private int arrayIndexOf(int index) {
        return validify(nextFirst + 1 + index);
    }

    /**
     * Resizes the backing array to the specified capacity.
     *
     * @param newCapacity new capacity of the backing array
     */
    private void resizeTo(int newCapacity) {
        //noinspection unchecked
        T[] newItems = (T[]) new Object[newCapacity];

        // find the first and last array index
        int firstArrayIndex = arrayIndexOf(0);
        int lastArrayIndex  = arrayIndexOf(size - 1);

        // copy the items to the new array
        if (firstArrayIndex <= lastArrayIndex) {
            // one whole part
            System.arraycopy(items, firstArrayIndex, newItems, 0, size);
        } else {
            // two separate parts
            int len1 = capacity() - firstArrayIndex;
            int len2 = size - len1;
            System.arraycopy(items, firstArrayIndex,
                    newItems, 0,
                    len1);
            System.arraycopy(items, 0,
                    newItems, len1,
                    len2);
        }

        // update backing array and pointer to nextFirst, nextLast
        items = newItems;
        nextFirst = capacity() - 1;
        nextLast = size;
    }

    /**
     * Smart resize the backing array to an appropriate capacity.
     */
    private void smartResize() {
        // Complete full, expand once,
        // resize up
        if (capacity() == size) {
            resizeTo(capacity() * RESIZE_FACTOR);
        }

        // Rather empty, can shrink twice,
        // resize down, but no less than INIT_CAPACITY
        if (capacity() > size * RESIZE_FACTOR * RESIZE_FACTOR
                && capacity() > INIT_CAPACITY * RESIZE_FACTOR) {
            resizeTo(capacity() / RESIZE_FACTOR);
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    @SuppressWarnings("NullableProblems")
    public Iterator<T> iterator() {
        return new Iterator<>() {
            /**
             * Current deque index in the iteration, ranging [0, size).
             * Gets item by {@code get(currentIndex)}.
             */
            private int currentIndex = 0;

            /**
             * Returns if the iterator has more elements.
             * @return {@code true} if the iterator has more elements, {@code false} otherwise.
             */
            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration.
             * @throws NoSuchElementException if the iterator has no more elements.
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return get(currentIndex++);
            }
        };
    }
}

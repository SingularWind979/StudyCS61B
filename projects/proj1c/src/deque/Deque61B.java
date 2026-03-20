package deque;

import java.util.List;

/**
 * The Deque61B abstract data type.
 *
 * @param <T> the type of items in the deque.
 * @author Josh Hug
 * @version 2.0
 */
public interface Deque61B<T> {
    /**
     * Adds {@code x} to the front of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    void addFirst(T x);

    /**
     * Adds {@code x} to the back of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    void addLast(T x);

    /**
     * Returns a List copy of the deque.
     * Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    List<T> toList();

    /**
     * Returns if the deque is empty.
     * Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    boolean isEmpty();

    /**
     * Returns the size of the deque.
     * Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    int size();

    /**
     * Removes and returns the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    T removeFirst();

    /**
     * Removes and returns the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    T removeLast();

    /**
     * Returns the element at the front of the deque, if it exists.
     * Does not alter the deque.
     *
     * @return element at the front of the deque, if it exists, {@code null} otherwise.
     */
    T getFirst();

    /**
     * Returns the element at the back of the deque, if it exists.
     * Does not alter the deque.
     *
     * @return element at the back of the deque, if it exists, {@code null} otherwise.
     */
    T getLast();

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
    T get(int index);

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
    T getRecursive(int index);
}

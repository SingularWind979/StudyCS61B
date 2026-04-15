import java.util.NoSuchElementException;

/**
 * Stack61B interface:
 * A Last-In-First-Out (LIFO) stack of objects.
 *
 * @param <T> the type of elements in this stack
 *
 * @author SingularWind
 */
@SuppressWarnings("unused")
public interface Stack61B<T> {
    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed
     */
    void push(T item);

    /**
     * Removes the object at the top of this stack and returns it.
     *
     * @return the object at the top of this stack
     * @throws NoSuchElementException if this deque is empty
     */
    T pop();

    /**
     * Looks at the object at the top of this stack without removing it.
     *
     * @return the object at the top of this stack, null if the stack is empty
     */
    T peek();

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    int size();

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if this stack is empty
     */
    boolean isEmpty();
}

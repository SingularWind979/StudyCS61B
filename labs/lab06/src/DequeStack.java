import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * DequeStack implementation:
 * A Deque based LIFO (Last-In-First-Out) stack implementation.
 *
 * @param <T> the type of elements stored in this stack
 *
 * @author SingularWind
 */
public class DequeStack<T> implements Stack61B<T> {
    /**
     * The underlying data structure to store items
     */
    private final Deque<T> stack;

    /**
     * Constructs an empty DequeStack
     * using an {@link ArrayDeque} as the underlying data structure.
     */
    public DequeStack() {
        stack = new ArrayDeque<>();
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param item the item to be pushed
     */
    @Override
    public void push(T item) {
        stack.push(item);
    }

    /**
     * Removes the object at the top of this stack and returns it.
     *
     * @return the object at the top of this stack
     * @throws NoSuchElementException if this deque is empty
     */
    @Override
    public T pop() {
        return stack.pop();
    }

    /**
     * Looks at the object at the top of this stack without removing it.
     *
     * @return the object at the top of this stack, null if the stack is empty
     */
    @Override
    public T peek() {
        return stack.peek();
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    @Override
    public int size() {
        return stack.size();
    }

    /**
     * Returns true if this stack contains no elements.
     *
     * @return true if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

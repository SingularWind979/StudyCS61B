/**
 * A singly-linked list implementation with a sentinel that supports rotation operations.
 * @param <T> the type of elements stored in the list
 *
 * @author SingularWind
 */
public class RotatingSLList<T> extends SLList<T> {
    /**
     * Moves the last item to the front of the list.
     */
    public void rotateRight() {
        T last = removeLast();
        addFirst(last);
    }

    /**
     * Moves the first item to the end of the list.
     */
    public void rotateLeft() {
        T first = removeFirst();
        addLast(first);
    }
}

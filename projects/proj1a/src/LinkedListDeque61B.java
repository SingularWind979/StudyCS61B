import java.util.ArrayList;
import java.util.List;

/**
 * Circular Doubly Linked Deque
 *
 * @author SingularWind
 * @param <T> the type of items in the deque
 */
public class LinkedListDeque61B<T> implements Deque61BA<T> {
    private class Node {
        T item;
        Node prev;
        Node next;

        Node() {
            this(null, null, null);
        }

        Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private final Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        // sentinel <- newFirst -> oldFirst
        Node newFirst = new Node(x, sentinel, sentinel.next);
        // sentinel -> newFirst
        newFirst.prev.next = newFirst;  // newFirst.prev is sentinel
        // newFirst <- oldFirst
        newFirst.next.prev = newFirst;  // newFirst.next is oldFirst
        size++;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        // oldLast <- newLast -> sentinel
        Node newLast = new Node(x, sentinel.prev, sentinel);
        // newLast <- sentinel
        newLast.next.prev = newLast;    // newLast.next is sentinel
        // oldLast -> newLast
        newLast.prev.next = newLast;    // newLast.prev is oldLast
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
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            returnList.add(p.item);
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
        if (isEmpty()) {
            return null;
        }
        // sentinel <-> oldFirst <-> newFirst
        Node oldFirst = sentinel.next;
        // sentinel -> newFirst
        oldFirst.prev.next = oldFirst.next; // oldFirst.prev is sentinel, oldFirst.next is newFirst
        // sentinel <- newFirst
        oldFirst.next.prev = oldFirst.prev; // oldFirst.next is newFirst, oldFirst.prev is sentinel
        size--;
        return oldFirst.item;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        // newLast <-> oldLast <-> sentinel
        Node oldLast = sentinel.prev;
        // newLast <- sentinel
        oldLast.next.prev = oldLast.prev;   // oldLast.next is sentinel, oldLast.prev is newLast
        // sentinel -> newLast
        oldLast.prev.next = oldLast.next;   // oldLast.prev is newLast , oldLast.next is sentinel
        size--;
        return oldLast.item;
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
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        } else if (index == size - 1) {
            return sentinel.prev.item;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
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
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(Node current, int index) {
        if (index == 0) {
            return  current.item;
        }
        return getRecursive(current.next, index - 1);
    }

    private void add(T x, int index) {

    }

    private T remove(int index) {
        return null;
    }
}

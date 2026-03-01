import java.util.ArrayList;
import java.util.List;

/**
 * Represents a linked list deque implementation of a deque.
 *
 * @param <T> the type of items stored in the deque
 * @author SingularWind
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
    /**
     * Represents a sentinel node in a doubly linked list.
     * The first real node in the deque is {@code sentinel.next}.
     * The last real node in the deque is {@code sentinel.prev}.
     * */
    private final Node sentinel;

    /**
     * Represents the current size of the deque.
     * The amount of real nodes in the deque, not including the {@code sentinel} node.
     */
    private int size;

    /**
     * Constructs an empty linked list deque.
     */
    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);

        sentinel.prev = sentinel;
        sentinel.next = sentinel;

        size = 0;
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
        return getFirstNode().item;
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
        return getLastNode().item;
    }

    /**
     * Add {@code x} to the front of the deque.
     * Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        Node oldFirst = getFirstNode();
        Node newFirst = new Node(x, sentinel, oldFirst);

        sentinel.next = newFirst;
        oldFirst.prev = newFirst;

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
        Node oldLast = getLastNode();
        Node newLast = new Node(x, oldLast, sentinel);

        sentinel.prev = newLast;
        oldLast.next = newLast;

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

        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            list.add(p.item);
        }

        return list;
    }

    /**
     * Returns if the deque is empty.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the deque.
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
     * @return element at {@code index} in the deque,
     * {@code null} if index is out of bounds.
     */
    @Override
    public T get(int index) {
        return getNode(index).item;
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
     * Returns the node at the given index in the deque,
     * or {@code sentinel} if index is out of bounds.
     * Remembers {@code sentinel.item} is null.
     *
     * @param index index to get
     * @return node at {@code index} in the deque
     */
    private Node getNode(int index) {
        // index is out of bounds
        if (index < 0 || index >= size) {
            return sentinel;
        }

        // iterate to the node
        Node p;

        // iterate from the front or the back
        if (index < size / 2) {
            p = sentinel.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
        } else {
            p = sentinel.prev;
            for (int i = size - 1; i > index; i--) {
                p = p.prev;
            }
        }

        return p;
    }

    /**
     * Returns the first node in the deque,
     * or {@code sentinel} if the deque is empty.
     * Remembers {@code sentinel.item} is null.
     *
     * @return the first node in the deque
     */
    private Node getFirstNode() {
        return sentinel.next;
    }


    /**
     * Returns the last node in the deque,
     * or {@code sentinel} if the deque is empty.
     * Remembers {@code sentinel.item} is null.
     *
     * @return the last node in the deque
     */
    private Node getLastNode() {
        return sentinel.prev;
    }

    /**
     * Represents a node in a doubly linked list.
     */
    private class Node {
        T item;
        Node prev;
        Node next;

        /**
         * Constructs a new node with the given item and pointers.
         *
         * @param item the item to store in the node
         * @param prev the previous node in the deque
         * @param next the next node in the deque
         */
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}

package deque;

import java.util.ArrayList;
import java.util.List;

/**
 * A linked list implementation of the Deque61B interface.
 *
 * @param <T> the type of items in the deque.
 * @author SingularWind
 * @version 2.0
 */
public class LinkedListDeque61B<T> implements Deque61B<T> {
    /**
     * The sentinel node in the deque,
     * sentinel.next the first actual node,
      sentinel.prev the last actual node.
     */
    private final Node<T> sentinel;
    /** The number of actual nodes in the deque. */
    private int size;

    /**
     * Constructs a new empty linked list deque.
     */
    public LinkedListDeque61B() {
        sentinel = new Node<>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

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

        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = new Node<>(x, sentinel, oldFirst);
        sentinel.next = newFirst;
        oldFirst.prev = newFirst;
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

        Node<T> oldLast = getLastNode();
        Node<T> newLast = new Node<>(x, oldLast, sentinel);
        sentinel.prev = newLast;
        oldLast.next = newLast;
        size++;

        checkInvariants();
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

        Node<T> current = getFirstNode();
        while (current != sentinel) {
            list.add(current.item);
            current = current.next;
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
     * Removes and returns the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        checkInvariants();

        if (isEmpty()) {
            return null;
        }

        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = oldFirst.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        size--;

        checkInvariants();

        return oldFirst.item;
    }

    /**
     * Removes and returns the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        checkInvariants();

        if (isEmpty()) {
            return null;
        }

        Node<T> oldLast = getLastNode();
        Node<T> newLast = oldLast.prev;
        sentinel.prev = newLast;
        newLast.next = sentinel;
        size--;

        checkInvariants();

        return oldLast.item;
    }

    /**
     * Returns the element at the front of the deque, if it exists.
     * Does not alter the deque.
     *
     * @return element at the front of the deque, if it exists, {@code null} otherwise.
     */
    @Override
    public T getFirst() {
        return !isEmpty()
                ? getFirstNode().item
                : null;
    }

    /**
     * Returns the element at the back of the deque, if it exists.
     * Does not alter the deque.
     *
     * @return element at the back of the deque, if it exists, {@code null} otherwise.
     */
    @Override
    public T getLast() {
        return !isEmpty()
                ? getLastNode().item
                : null;

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
                ? getNode(index).item
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
        return isValid(index)
                ? getNodeRecursive(getFirstNode(), index).item
                : null;
    }

    /**
     * Checks the invariants of the linked list deque implementation.
     */
    private void checkInvariants() {
        // check sentinel structure, stores no item, and doesn't point to null
        assert sentinel.item == null: "sentinel.item is not null";
        assert sentinel.next != null: "sentinel.next is null";
        assert sentinel.prev != null: "sentinel.prev is null";

        // check first and last node point to sentinel node
        assert sentinel.next.prev == sentinel: "first.prev is not sentinel";
        assert sentinel.prev.next == sentinel: "last.next is not sentinel";
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
     * Returns the node at the given index.
     * Assumes index is valid.
     *
     * @param index index to get
     * @return node at {@code index} in the deque
     */
    private Node<T> getNode(int index) {
        Node<T> current = getFirstNode();
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /**
     * Returns the node at the given index, recursively.
     * Assumes index is valid.
     *
     * @param index index to get
     * @return node at {@code index} in the deque
     */
    private Node<T> getNodeRecursive(Node<T> current, int index) {
        if (index == 0) {
            return current;
        }
        return getNodeRecursive(current.next, index - 1);
    }

    /**
     * Returns the first node in the deque.
     * Assumes index is valid.
     *
     * @return first node in the deque
     */
    private Node<T> getFirstNode() {
        return sentinel.next;
    }

    /**
     * Returns the last node in the deque.
     * Assumes index is valid.
     *
     * @return last node in the deque
     */
    private Node<T> getLastNode() {
        return sentinel.prev;
    }

    /**
     * A node in the linked list deque.
     *
     * @param <T> the type of items in the deque.
     */
    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        /**
         * Constructs a new node with the given item, next node, and previous node.
         *
         * @param item the item to store in the node
         * @param next the next node in the deque
         * @param prev the previous node in the deque
         */
        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}

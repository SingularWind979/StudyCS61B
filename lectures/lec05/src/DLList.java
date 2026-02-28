/**
 * Doubly-linked list implementation with 2 sentinels.
 * @param <T> the type of elements stored in the list
 *
 * @author SingularWind
 */
public class DLList<T> implements List<T> {
    private int size;               // number of real nodes in the list
    private final Node<T> sentF;    // sentinel node for the front
    private final Node<T> sentB;    // sentinel node for the back

    /**
     * Constructs an empty DLList.
     */
    public DLList() {
        size = 0;
        sentF = new Node<>(null);
        sentB = new Node<>(null);
        sentF.next = sentB;
        sentB.prev = sentF;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the item at the given index.
     *
     * @param index the index of the item to return
     * @return the item at the given index
     */
    @Override
    public T get(int index) {
        // check if index is valid
        checkIndex(index);

        // return the item at the given index
        return getNode(index).data;
    }

    /**
     * Inserts the given item at the given index.
     *
     * @param item  the item to insert
     * @param index the index at which to insert the item
     */
    @Override
    public void insert(T item, int index) {
        // insert can be at the end, which is out of index
        if (index == size) {
            addLast(item);
            return;
        }

        // check if index is valid
        checkIndex(index);

        // insert the item at the given index
        Node<T> oldNode = getNode(index);
        Node<T> newNode = new Node<>(item, oldNode.prev, oldNode);
        oldNode.prev.next = newNode;
        oldNode.prev = newNode;
        size++;
    }

    /**
     * Removes and returns the item at the given index.
     *
     * @param index the index of the item to remove
     * @return the item at the given index
     */
    @Override
    public T remove(int index) {
        // check if index is valid
        checkIndex(index);

        // remove the item at the given index
        Node<T> oldNode = getNode(index);
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
        size--;

        // return the removed item at the given index
        return oldNode.data;
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element in the list
     */
    @Override
    public T getFirst() {
        return getFirstNode().data;
    }

    /**
     * Returns the last element in the list.
     *
     * @return the last element in the list
     */
    @Override
    public T getLast() {
        return getLastNode().data;
    }

    /**
     * Adds a new element to the front of the list.
     *
     * @param data the element to be added to the front of the list
     */
    @Override
    public void addFirst(T data) {
        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = new Node<>(data, sentF, oldFirst);
        sentF.next = newFirst;
        oldFirst.prev = newFirst;
        size++;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param data the element to be added to the end of the list
     */
    @Override
    public void addLast(T data) {
        Node<T> oldLast = getLastNode();
        Node<T> newLast = new Node<>(data, oldLast, sentB);
        sentB.prev = newLast;
        oldLast.next = newLast;
        size++;
    }

    /**
     * Removes and returns the first element in the list.
     *
     * @return the first element in the list
     */
    @Override
    public T removeFirst() {
        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = oldFirst.next;
        sentF.next = newFirst;
        newFirst.prev = sentF;
        size--;
        return oldFirst.data;
    }

    /**
     * Removes and returns the last element in the list.
     *
     * @return the last element in the list
     */
    @Override
    public T removeLast() {
        Node<T> oldLast = getLastNode();
        Node<T> newLast = oldLast.prev;
        sentB.prev = newLast;
        newLast.next = sentB;
        size--;
        return oldLast.data;
    }

    /**
     * Returns the node at the given index.
     *
     * @param index the index of the node to return
     * @return the node at the given index
     */
    private Node<T> getNode(int index) {
        Node<T> current;

        // if index is less than half of the size,
        // traverse from the front,
        // else traverse from the back
        if (index < size / 2) {
            current = getFirstNode();
            for (int i = 0; i <= index; i++) {
                current = current.next;
            }
        } else {
            current = getLastNode();
            for (int i = size - 1; i >= index; i--) {
                current = current.prev;
            }
        }

        return current;
    }

    /**
     * Returns the first node in the list.
     *
     * @return the first node in the list
     */
    private Node<T> getFirstNode() {
        return sentF.next;
    }

    /**
     * Returns the last node in the list.
     *
     * @return the last node in the list
     */
    private Node<T> getLastNode() {
        return sentB.prev;
    }

    /**
     * Checks if the given index is valid for this list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is not valid for this list
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DLList[");
        for (Node<T> p = sentF.next; p != sentB; p = p.next) {
            sb.append(p.data);
            if (p.next != sentB) {
                sb.append(" -> ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Node class to store the data and the prev/next nodes.
     */
    private static class Node<T> {
        T data;   // data stored in the node
        Node<T> prev;  // pointer to the prev node
        Node<T> next;  // pointer to the next node

        /**
         * Constructs a new node with the specified data.
         *
         * @param data the data to be stored in the node
         */
        Node(T data) {
            this.data = data;
        }

        /**
         * Constructs a new node with the specified data, prev, and next nodes.
         *
         * @param data the data to be stored in the node
         * @param prev the previous node in the list
         * @param next the next node in the list
         */
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}

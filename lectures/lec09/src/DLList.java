/**
 * Doubly-linked list implementation with 2 sentinels.
 * @param <T> the type of elements stored in the list
 *
 * @author SingularWind
 */
public class DLList<T> extends AbstractList<T> {
    private final Node<T> sentF;    // sentinel node for the front
    private final Node<T> sentB;    // sentinel node for the back

    /**
     * Constructs an empty DLList.
     */
    public DLList() {
        sentF = new Node<>(null);
        sentB = new Node<>(null);
        sentF.next = sentB;
        sentB.prev = sentF;
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
        return getNode(index).item;
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

        // insert the new node before the old node
        Node<T> oldNode = getNode(index);
        Node<T> newNode = new Node<>(item, oldNode.prev, oldNode);
        newNode.prev.next = newNode;
        newNode.next.prev = newNode;
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
        // check if list is empty
        checkEmptyList();
        // check if index is valid
        checkIndex(index);

        // remove the node at the given index
        Node<T> oldNode = getNode(index);
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
        size--;

        return oldNode.item;
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element in the list
     */
    @Override
    public T getFirst() {
        // check if list is empty
        checkEmptyList();

        return getFirstNode().item;
    }

    /**
     * Returns the last element in the list.
     *
     * @return the last element in the list
     */
    @Override
    public T getLast() {
        // check if list is empty
        checkEmptyList();

        return getLastNode().item;
    }

    /**
     * Adds a new element to the front of the list.
     *
     * @param item the item to be added to the front of the list
     */
    @Override
    public void addFirst(T item) {
        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = new Node<>(item, sentF, oldFirst);
        sentF.next = newFirst;
        oldFirst.prev = newFirst;
        size++;
    }

    /**
     * Adds a new element to the end of the list.
     *
     * @param item the item to be added to the end of the list
     */
    @Override
    public void addLast(T item) {
        Node<T> oldLast = getLastNode();
        Node<T> newLast = new Node<>(item, oldLast, sentB);
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
        // check if list is empty
        checkEmptyList();

        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = oldFirst.next;
        sentF.next = newFirst;
        newFirst.prev = sentF;
        size--;

        return oldFirst.item;
    }

    /**
     * Removes and returns the last element in the list.
     *
     * @return the last element in the list
     */
    @Override
    public T removeLast() {
        // check if list is empty
        checkEmptyList();

        Node<T> oldLast = getLastNode();
        Node<T> newLast = oldLast.prev;
        sentB.prev = newLast;
        newLast.next = sentB;
        size--;

        return oldLast.item;
    }

    /**
     * Returns the node at the given index.
     * Assumes that the index is valid.
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

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = getLastNode();

            for (int i = size - 1; i > index; i--) {
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
     * Returns the connector character used in the string representation of this list.
     *
     * @return the connector character used in the string representation of this list
     */
    @Override
    protected String connector() {
        return " <-> ";
    }

    /**
     * Node class to store the item and the prev/next nodes.
     */
    private static class Node<T> {
        T item;   // item stored in the node
        Node<T> prev;  // pointer to the prev node
        Node<T> next;  // pointer to the next node

        /**
         * Constructs a new node with the specified item.
         *
         * @param item the item to be stored in the node
         */
        public Node(T item) {
            this.item = item;
        }

        /**
         * Constructs a new node with the specified item, prev, and next nodes.
         *
         * @param item the item to be stored in the node
         * @param prev the previous node in the list
         * @param next the next node in the list
         */
        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
}

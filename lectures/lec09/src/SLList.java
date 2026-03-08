/**
 * Singly-linked list implementation with a sentinel.
 * @param <T> the type of elements stored in the list
 *
 * @author SingularWind
 */
@SuppressWarnings("UnnecessaryLocalVariable")
public class SLList<T> extends AbstractList<T> {
    private final Node<T> sentF;    // sentinel node for the front
    private final Node<T> sentB;    // sentinel node for the back

    /**
     * Constructs an empty SLList.
     */
    public SLList() {
        sentF = new Node<>(null);
        sentB = new Node<>(null);
        sentF.next = sentB;
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
        Node<T> prevNode = getNode(index - 1);
        Node<T> nextNode = prevNode.next;
        Node<T> newNode = new Node<>(item);
        prevNode.next = newNode;
        newNode.next = nextNode;
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

        // remove the node at index
        Node<T> prevNode = getNode(index - 1);
        Node<T> oldNode = prevNode.next;
        Node<T> nextNode = oldNode.next;
        prevNode.next = nextNode;
        size--;

        return oldNode.item;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws RuntimeException if the list is empty
     */
    @Override
    public T getFirst() {
        // check if list is empty
        checkEmptyList();

        return getFirstNode().item;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws RuntimeException if the list is empty
     */
    @Override
    public T getLast() {
        // check if list is empty
        checkEmptyList();

        return getLastNode().item;
    }

    /**
     * Adds the specified element to the beginning of this list.
     *
     * @param item the element to add
     */
    @Override
    public void addFirst(T item) {
        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = new Node<>(item);
        sentF.next = newFirst;
        newFirst.next = oldFirst;
        size++;
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param item the element to add
     */
    @Override
    public void addLast(T item) {
        Node<T> oldLast = getLastNode();
        Node<T> newLast = new Node<>(item);
        oldLast.next = newLast;
        newLast.next = sentB;
        size++;
    }

    /**
     * Removes and returns the first item in the list.
     *
     * @return the first item in the list
     */
    @Override
    public T removeFirst() {
        // check if list is empty
        checkEmptyList();

        Node<T> oldFirst = getFirstNode();
        Node<T> newFirst = oldFirst.next;
        sentF.next = newFirst;
        size--;

        return oldFirst.item;
    }

    /**
     * Removes and returns the last item in the list.
     *
     * @return the last item in the list
     */
    @Override
    public T removeLast() {
        // check if list is empty
        checkEmptyList();

        Node<T> oldLast = getLastNode();
        Node<T> newLast = size <= 1 ?
                sentF : getNode(size - 2);
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
        Node<T> current = getFirstNode();

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    /**
     * Returns the first node in this list.
     *
     * @return the first node in this list
     */
    private Node<T> getFirstNode() {
        return sentF.next;
    }

    /**
     * Returns the last node in this list.
     *
     * @return the last node in this list
     */
    private Node<T> getLastNode() {
        Node<T> current = sentF;

        while (current.next != sentB) {
            current = current.next;
        }

        return current;
    }

    /**
     * Returns the connector character used in the string representation of this list.
     *
     * @return the connector character used in the string representation of this list
     */
    @Override
    protected String connector() {
        return " -> ";
    }

    /**
     * Node class to store the item and the next node.
     *
     * @param <T> the type of item stored in the node
     */
    private static class Node<T> {
        T item;         // item stored in the node
        Node<T> next;   // pointer to the next node

        public Node(T item) {
            this.item = item;
        }
    }
}

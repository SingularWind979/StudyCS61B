/**
 * Doubly-linked list implementation with 2 sentinels.
 * @param <T> the type of elements stored in the list
 *
 * @author SingularWind
 */
public class DLList<T> {
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
    public int size() {
        return size;
    }

    /**
     * Returns true if the list is empty, false otherwise.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first element in the list.
     *
     * @return the first element in the list
     */
    public T getFirst() {
        return getFirstNode().data;
    }

    /**
     * Returns the last element in the list.
     *
     * @return the last element in the list
     */
    public T getLast() {
        return getLastNode().data;
    }

    /**
     * Adds a new element to the front of the list.
     *
     * @param data the element to be added to the front of the list
     */
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
    public T removeLast() {
        Node<T> oldLast = getLastNode();
        Node<T> newLast = oldLast.prev;
        sentB.prev = newLast;
        newLast.next = sentB;
        size--;
        return oldLast.data;
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
}

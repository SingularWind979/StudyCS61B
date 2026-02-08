@SuppressWarnings("FieldMayBeFinal")
public class SLList<T> {
    /**
     * Node class to store the data and the next node.
     *
     * @param <T> the type of data stored in the node
     */
    private static class Node<T> {
        T data;         // data stored in the node
        Node<T> next;   // pointer to the next node
        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> sentinel;   // sentinel node
    private int size;           // number of real nodes in the list

    /**
     * Constructs an empty SLList.
     */
    public SLList() {
        sentinel = new Node<>(null, null);
        size = 0;
    }

    /**
     * Adds the specified element to the beginning of this list.
     *
     * @param data the element to add
     */
    public void addFirst(T data) {
        Node<T> oldFirst = getFirstNode();
        sentinel.next = new Node<>(data, oldFirst);
        size++;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws RuntimeException if the list is empty
     */
    public T getFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return getFirstNode().data;
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param data the element to add
     */
    public void addLast(T data) {
        Node<T> oldLast = getLastNode();
        oldLast.next = new Node<>(data, null);
        size++;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws RuntimeException if the list is empty
     */
    public T getLast() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return getLastNode().data;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list is empty.
     *
     * @return true if this list is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SLList[");
        for (Node<T> p = sentinel.next; p != null; p = p.next) {
            sb.append(p.data);
            if (p.next != null) {
                sb.append("->");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private Node<T> getFirstNode() {
        return sentinel.next;
    }

    private Node<T> getLastNode() {
        Node<T> p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }
}

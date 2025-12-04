/**
 * Name: SLList (Singly Linked List linear with one front sentinel).
 * Topology: sentinel → node1 → node2 → node3 → ... → nodeN
 *
 * @param <T> Type of elements in the list
 * @author Singularwind
 * */
public class SLList<T> implements MyList<T> {
    /** singly linked node */
    private static class Node<T> {
        public T item;
        public Node<T> next;
        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    // sentinel.next is the first node
    private Node<T> sentinel;
    // size of the list
    private int size;
    SLList() {
        sentinel = new Node<>(null, null);
        size = 0;
    }
    SLList(T item) {
        this();
        addFirst(item);
    }

    /**
     * Add an item to the front of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addFirst(T item) {
        sentinel.next = new Node<>(item, sentinel.next);
        size++;
    }

    /**
     * Add an item to the end of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addLast(T item) {
        Node<T> p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new Node<>(item, null);
        size++;
    }

    /**
     * Retrieves the first item in the list.
     *
     * @return the first item
     */
    @Override
    public T getFirst() {
        if (sentinel.next == null) {
            throw new IllegalStateException("List is empty");
        }
        return sentinel.next.item;
    }

    /**
     * Retrieves the last item of the list.
     *
     * @return the last item
     */
    @Override
    public T getLast() {
        if (sentinel.next == null) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    /**
     * Removes and returns the first item of the list.
     *
     * @return the removed item
     */
    @Override
    public T removeFirst() {
        return null;
    }

    /**
     * Removes and returns the first item of the list.
     *
     * @return the removed item
     */
    @Override
    public T removeLast() {
        return null;
    }

    /**
     * Retrieves the {@code index}th item of the list.
     *
     * @param index the index of the item you want
     * @return the {@code index}th item
     */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    /**
     * Inserts an item at the specified index.
     *
     * @param item  the item to insert
     * @param index the position to insert
     * @return the inserted item
     */
    @Override
    public T insert(T item, int index) {
        return null;
    }

    /**
     * Returns the size of the list (number of items).
     *
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }
}

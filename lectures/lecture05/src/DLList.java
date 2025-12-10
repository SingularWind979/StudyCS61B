/**
 * Name: DLList (Doubly Linked List linear with two sentinels).
 * Topology: sentF ⇄ node1 ⇄ node2 ⇄ node3 ⇄ ... ⇄ nodeN ⇄ sentB
 *
 * @param <T> Type of elements in the list
 * @author Singularwind
 */
public class DLList<T> implements MyList<T> {
    /** doubly linked node */
    private static class Node<T> {
        public T item;
        public Node<T> prev;
        public Node<T> next;
        public Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    // sentinelFront
    private Node<T> sentF;
    // sentinelBack
    private Node<T> sentB;
    // size of the real node
    private int size;
    /** constructor of an empty list */
    DLList() {
        sentF = new Node<>(null, null, null);
        sentB = new Node<>(null, null, null);
        setEmpty();
    }

    /**
     * Add an item to the front of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addFirst(T item) {
        Node<T> first = first();
        Node<T> newFirst = new Node<>(item, sentF, first);
        first.prev = newFirst;
        sentF.next = newFirst;
        updateSize(+1);
    }

    /**
     * Add an item to the end of the list.
     *
     * @param item the item to add
     */
    @Override
    public void addLast(T item) {
        Node<T> last = last();
        Node<T> newLast = new Node<>(item, last, sentB);
        last.next = newLast;
        sentB.prev = newLast;
        updateSize(+1);
    }

    /**
     * Retrieves the first item in the list.
     *
     * @return the first item
     */
    @Override
    public T getFirst() {
        checkEmpty();
        return first().item;    }

    /**
     * Retrieves the last item of the list.
     *
     * @return the last item
     */
    @Override
    public T getLast() {
        checkEmpty();
        return last().item;    }

    /**
     * Removes and returns the first item of the list.
     *
     * @return the removed item
     */
    @Override
    public T removeFirst() {
        checkEmpty();
        T item = first().item;
        Node<T> newFirst = first().next;
        newFirst.prev = sentF;
        sentF.next = newFirst;
        updateSize(-1);
        return item;
    }

    /**
     * Removes and returns the last item of the list.
     *
     * @return the removed item
     */
    @Override
    public T removeLast() {
        checkEmpty();
        T last = last().item;
        Node<T> newLast = last().prev;
        newLast.next = sentB;
        sentB.prev = newLast;
        updateSize(-1);
        return last;
    }

    /**
     * Retrieves the {@code index}th item of the list.
     *
     * @param index the index of the item you want
     * @return the {@code index}th item
     */
    @Override
    public T get(int index) {
        return getNode(index).item;
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
        Node<T> oldIthItem = getNode(index);
        Node<T> newIthItem = new Node<>(item, oldIthItem.prev, oldIthItem);
        return item;
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

    /**
     * Print the items of the list.
     */
    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("List:[");
        for( Node<T> p = sentF.next; p != sentB; p = p.next) {
            sb.append(p.item).append("->");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        System.out.println(sb);
    }

    /** check if the list is empty */
    private void checkEmpty() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }
    }

    /** set the list to empty state */
    private void setEmpty() {
        sentF.next = sentB;
        sentB.prev = sentF;
        size = 0;
    }

    /** return current first node */
    private Node<T> first() {
        return sentF.next;
    }

    /** return current last node */
    private Node<T> last() {
        return sentB.prev;
    }

    /** wrapper update size operation into a function */
    private void updateSize(int delta) {
        size += delta;
    }

    /** clear the list */
    public void clear() {
        setEmpty();
    }

    private Node<T> getNode(int index) {
            Node<T> p = sentF.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p;
    }
}

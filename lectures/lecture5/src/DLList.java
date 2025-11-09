/**
 * Name: DLList (Doubly Linked List linear with two sentinels)
 * Topology: sentF ⇄ node1 ⇄ node2 ⇄ node3 ⇄ ... ⇄ nodeN ⇄ sentB
 * */
public class DLList<T> {
    /** doubly linked node */
    private class Node {
        public T item;
        public Node prev;
        public Node next;
        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    // sentinelFront
    private Node sentF;
    // sentinelBack
    private Node sentB;
    // size of the real node
    private int size;
    /** constructor of an empty list */
    DLList() {
        sentF = new Node(null, null, null);
        sentB = new Node(null, null, null);
        setEmpty();
    }


    /*
      helper methods
     */

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
    private Node first() {
        return sentF.next;
    }

    /** return current last node */
    private Node last() {
        return sentB.prev;
    }

    /** wrapper update size operation into a function */
    private void updateSize(int delta) {
        size += delta;
    }


    /*
      list related methods
     */

    /** return the size of the list */
    public int size() {
        return size;
    }

    /** clear the list */
    public void clear() {
        setEmpty();
    }

    /** print the list */
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("List:[ ");
        for( Node p = sentF.next; p != sentB; p = p.next) {
            sb.append(p.item).append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }


    /*
      first node related methods
     */

    /** return item of the first node */
    public T getFirst() {
        checkEmpty();
        return first().item;
    }

    /** add an item to the first position */
    public void addFirst(T item) {
        Node first = first();
        Node newFirst = new Node(item, sentF, first);
        first.prev = newFirst;
        sentF.next = newFirst;
        updateSize(+1);
    }

    /** remove the first node */
    public void removeFirst() {
        checkEmpty();
        Node newFirst = first().next;
        newFirst.prev = sentF;
        sentF.next = newFirst;
        updateSize(-1);
    }


    /*
      last node related methods
     */

    /** return the item of the last node */
    public T getLast() {
        checkEmpty();
        return last().item;
    }

    /** add an item to the last position */
    public void addLast(T item) {
        Node last = last();
        Node newLast = new Node(item, last, sentB);
        last.next = newLast;
        sentB.prev = newLast;
        updateSize(+1);
    }

    /** remove the last node */
    public void removeLast() {
        checkEmpty();
        Node newLast = last().prev;
        newLast.next = sentB;
        sentB.prev = newLast;
        updateSize(-1);
    }


    /*
     test code
     */
    public static void main(String[] args) {
        DLList<Integer> list = new DLList<>();

        // ✅ Test addFirst and addLast
        list.addFirst(10);
        list.print();
        list.addFirst(5);
        list.print();
        list.addLast(15);
        list.print();
        list.addLast(20);
        list.print();

        System.out.println("Size after adding: " + list.size());  // expect 4
        System.out.println("First: " + list.getFirst());           // expect 5
        System.out.println("Last: " + list.getLast());             // expect 20

        // ✅ Test removeFirst and removeLast
        list.removeFirst();  // removes 5
        list.print();
        list.removeLast();   // removes 20
        list.print();

        System.out.println("Size after removing: " + list.size()); // expect 2
        System.out.println("First: " + list.getFirst());           // expect 10
        System.out.println("Last: " + list.getLast());             // expect 15

        // ✅ Test empty behavior
        list.removeFirst();  // removes 10
        list.print();
        list.removeLast();   // removes 15
        list.print();

        System.out.println("Size after clearing: " + list.size()); // expect 0

        try {
            list.getFirst(); // should throw
        } catch (IllegalStateException e) {
            System.out.println("Caught expected exception: " + e.getMessage());
        }
    }
}

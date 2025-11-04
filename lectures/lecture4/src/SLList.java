public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;
        IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    // sentinel.next is the first node
    private IntNode sentinel;
    private int size;

    SLList() {
        sentinel = new IntNode(-1, null);
        size = 0;
    }

    SLList(int item) {
        this();
        addFirst(item);
    }

    /** Returns the number of items in the list using recursion. */
    public int size() {
        return size;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int item) {
        sentinel.next = new IntNode(item, sentinel.next);
        size++;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        if (sentinel.next == null) {
            throw new IllegalStateException("List is empty");
        }
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int item) {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(item, null);
        size++;
    }
    /** Retrieves the last item from the list. */
    public int getLast() {
        if (sentinel.next == null) {
            throw new IllegalStateException("List is empty");
        }
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    public static void main(String[] args) {
        SLList list = new SLList();

        // ✅ Test addFirst
        list.addFirst(10);
        list.addFirst(5);
        System.out.println("After addFirst: first = " + list.getFirst()); // expect 5
        System.out.println("Size = " + list.size());                      // expect 2

        // ✅ Test addLast
        list.addLast(15);
        list.addLast(20);
        System.out.println("After addLast: last = " + list.getLast());    // expect 20
        System.out.println("Size = " + list.size());                      // expect 4

        // ✅ Test getFirst and getLast
        System.out.println("First element: " + list.getFirst());          // expect 5
        System.out.println("Last element: " + list.getLast());            // expect 20

        // ✅ Add and check again
        list.addFirst(1);
        list.addLast(25);
        System.out.println("After more adds: first = " + list.getFirst()); // expect 1
        System.out.println("Last = " + list.getLast());                    // expect 25
        System.out.println("Final size = " + list.size());                 // expect 6
    }
}

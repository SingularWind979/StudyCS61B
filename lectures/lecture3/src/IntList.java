public class IntList {
    int data;
    IntList next;

    public IntList(int data, IntList next) {
        this.data = data;
        this.next = next;
    }

    public IntList(int data) {
        this(data, null);
    }

    /**
     * recursiveSize
     * @return size of the list
     */
    public int recursiveSize() {
        if (next == null) return 1;
        return next.recursiveSize() + 1;
    }


    /**
     * iterativeSize
     * @return size of the list
     */
    public int iterativeSize() {
        int size = 1;
        for (IntList p = this; p.next != null; p = p.next) {
            size++;
        }
        return size;
    }

    /**
     * recursiveGet
     * @param index the index of the node
     * @return the data of node[index]
     */
    public int recursiveGet(int index) {
        if (index < 0 || index >= recursiveSize()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) return data;
        return next.recursiveGet(index - 1);
    }

    /**
     * iterativeGet
     * @param index the index of the node
     * @return the data of node[index]
     */
    public int iterativeGet(int index) {
        if (index < 0 || index >= iterativeSize()) {
            throw new IndexOutOfBoundsException();
        }

        IntList p = this;
        for (int i = 0; i < index; i++, p = p.next);
        return  p.data;
    }

    /**
     * incrList
     * @param L the original IntList
     * @param x increment
     * @return Returns a new IntList (incremented)
     */
    public static IntList incrList(IntList L, int x) {
        if (L == null) return null;
        return new IntList(L.data + x, incrList(L.next, x));
    }

    /**
     * dincrList
     * @param L the original IntList
     * @param x increment
     * @return Returns the original IntList (incremented)
     */
    public static IntList dincrList(IntList L, int x) {
        for(IntList p = L; p != null; p = p.next) {
            p.data += x;
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(1, new IntList(2, new IntList(3)));

        // Size
        System.out.println(L.iterativeSize()); // 3
        System.out.println(L.recursiveSize()); // 3

        // Get
        System.out.println(L.iterativeGet(1)); // 2
        System.out.println(L.recursiveGet(2)); // 3

        // Increment (new list)
        IntList L2 = IntList.incrList(L, 5);
        System.out.println(L2.iterativeGet(0)); // 6

        // Increment in-place
        IntList.dincrList(L, 10);
        System.out.println(L.iterativeGet(0)); // 11
    }
}

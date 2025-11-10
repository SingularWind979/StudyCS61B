public class IntList {
    public int data;
    public IntList next;

    // Constructor to initialize the list
    IntList(int data, IntList next) {
        this.data = data;
        this.next = next;
    }

    /** =======================
     * Size methods
     * ======================= */
    public int size() {
        return recursiveSize(); // or return iterativeSize();
    }

    private int recursiveSize() {
        if (next ==null)    return 1;
        return 1 + next.recursiveSize();
    }

    private int iterativeSize() {
        int size = 1;
        for (IntList p = this; p != null; p = p.next) {
            size++;
        }
        return size;
    }

    /** =======================
     * Get methods
     * ======================= */
    public int get(int index) {
        if(index < 0 || index >= size()) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        return  recursiveGet(index);    // or return iterativeGet(index);
    }

    private int recursiveGet(int index) {
        if (index == 0) return data;
        return next.recursiveGet(index - 1);
    }

    private int iterativeGet(int index) {
        int size = 0;
        for(IntList p = this; p != null; p = p.next) {
            size++;
        }
        return size;
    }

    /** =======================
     * Increment methods
     * ======================= */
    public static IntList incrList(IntList L, int x) {
        IntList newList = null;
        IntList q = null;
        for (IntList p = L; p != null; p = p.next) {
            IntList newNode = new IntList(p.data + x, q);
            if (newList == null) {
                newList = newNode;
                q = newList;
            } else {
                q = newNode;
            }
        }
        return newList;
    }

    public static IntList dincrList(IntList L, int x) {
        for(IntList p = L; p != null; p = p.next) {
            p.data += x;
        }
        return L;
}

    /** =======================
     * Add first
     * ======================= */
    private IntList addFirst(int x) { // functional
        return new IntList(x, next);
    }

    private void daddFirst(int x) { // in-place
        IntList copy = new IntList(data, next);
        data = x;
        next = copy;
    }

    /** =======================
     * Get first element
     * ======================= */
    public int getFirst() {
        return data;
    }

    /** =======================
     * Utility: print list
     * ======================= */
    public void printList() {
        for (IntList p = this; p != null; p = p.next) {
            System.out.print(p.data + " ");
        }
    }

    /** =======================
     * Main demo and tests
     * ======================= */
    public static void main(String[] args) {

    }
}

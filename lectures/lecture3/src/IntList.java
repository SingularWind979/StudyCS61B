public class IntList {
    int num;
    IntList rest;

    public IntList(int num, IntList rest) {
        this.num = num;
        this.rest = rest;
    }

    public IntList(int num) {
        this(num, null);
    }

    /** =======================
     * Size methods
     * ======================= */
    public int recursiveSize() {
        if (rest == null) return 1;
        return rest.recursiveSize() + 1;
    }

    public int iterativeSize() {
        int size = 1;
        for (IntList p = this; p.rest != null; p = p.rest) {
            size++;
        }
        return size;
    }

    /** =======================
     * Get methods
     * ======================= */
    public int recursiveGet(int index) {
        if (index < 0 || index >= recursiveSize()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) return num;
        return rest.recursiveGet(index - 1);
    }

    public int iterativeGet(int index) {
        if (index < 0 || index >= iterativeSize()) {
            throw new IndexOutOfBoundsException();
        }
        IntList p = this;
        for (int i = 0; i < index; i++, p = p.rest);
        return p.num;
    }

    /** =======================
     * Increment methods
     * ======================= */
    public static IntList incrList(IntList L, int x) {
        if (L == null) return null;
        return new IntList(L.num + x, incrList(L.rest, x));
    }

    public static IntList dincrList(IntList L, int x) {
        for (IntList p = L; p != null; p = p.rest) {
            p.num += x;
        }
        return L;
    }

    /** =======================
     * Add first
     * ======================= */
    public IntList addFirst(int x) { // functional
        return new IntList(x, this);
    }

    public void addFirstInPlace(int x) { // in-place
        IntList temp = new IntList(num, rest);
        num = x;
        rest = temp;
    }

    /** =======================
     * Get first element
     * ======================= */
    public int getFirst() {
        return num;
    }

    /** =======================
     * Utility: print list
     * ======================= */
    public void printList() {
        for (IntList p = this; p != null; p = p.rest) {
            System.out.print(p.num + " ");
        }
        System.out.println();
    }

    /** =======================
     * Main demo
     * ======================= */
    public static void main(String[] args) {
        // Original list
        IntList L = new IntList(1, new IntList(2, new IntList(3)));
        System.out.println("Original list:");
        L.printList(); // 1 2 3

        // Size
        System.out.println("Size (iterative): " + L.iterativeSize()); // 3
        System.out.println("Size (recursive): " + L.recursiveSize()); // 3

        // Get
        System.out.println("Get index 1 (iterative): " + L.iterativeGet(1)); // 2
        System.out.println("Get index 2 (recursive): " + L.recursiveGet(2)); // 3

        // Increment (new list)
        IntList L2 = IntList.incrList(L, 5);
        System.out.println("New list after incrList +5:");
        L2.printList(); // 6 7 8

        // Increment in-place
        IntList.dincrList(L, 10);
        System.out.println("Original list after dincrList +10:");
        L.printList(); // 11 12 13

        // Add first (functional)
        L = L.addFirst(0);
        System.out.println("After addFirst(0) (functional):");
        L.printList(); // 0 11 12 13

        // Add first in-place
        L.addFirstInPlace(-1);
        System.out.println("After addFirstInPlace(-1) (in-place):");
        L.printList(); // -1 0 11 12 13
    }
}

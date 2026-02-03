/**
 * IntList class represents a singly linked list of integers.
 *
 * @author SingularWind
 */
@SuppressWarnings("SameParameterValue")
public class IntList {
    int data;                       // data stored in this node
    IntList next;                   // reference to the next node in the list
    static final int LIMIT = 1000;  // threshold for using iterative method

    /**
     * Constructs a new IntList node with the specified data and next node.
     *
     * @param data the data to be stored in this node
     * @param next the next node in the list
     */
    public IntList(int data, IntList next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return recursiveSize();
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    public int get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size());
        }
        if (index < LIMIT) {
            return recursiveGet(index).data;
        } else {
            return iterativeGet(index).data;
        }
    }

    /**
     * Increments each element in the list by x.
     *
     * @param L the list to be incremented
     * @param x the value to be added to each element in the list
     * @return a new list with each element incremented by x
     * @throws NullPointerException if L is null
     */
    public static IntList increment(IntList L, int x) {
        if (L == null) {
            throw new NullPointerException("L is null");
        }
        return creativeIncrement(L, x);
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("IntList(");
        for (IntList p = this; p != null; p = p.next) {
            sb.append(p.data);
            if (p.next != null) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Returns the number of elements in this list using a recursive approach.
     *
     * @return the number of elements in this list
     */
    private int recursiveSize() {
        if (next == null) {
            return 1;
        }
        return 1 + next.recursiveSize();
    }

    /**
     * Returns the number of elements in this list using an iterative approach.
     *
     * @return the number of elements in this list
     */
    private int iterativeSize() {
        int size = 0;
        for (IntList p = this; p != null; p = p.next) {
            size++;
        }
        return size;
    }

    /**
     * Returns the element at the specified position in this list using a recursive approach.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     */
    private IntList recursiveGet(int index) {
        if (index == 0) {
            return this;
        }
        return next.recursiveGet(index - 1);
    }

    /**
     * Returns the element at the specified position in this list using an iterative approach.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in this list
     */
    private IntList iterativeGet(int index) {
        IntList p = this;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p;
    }

    /**
     * Increments each element in the list by x using a creative approach.
     *
     * @param L the list to be incremented
     * @param x the value to be added to each element in the list
     * @return a new list with each element incremented by x
     */
    private static IntList creativeIncrement(IntList L, int x) {
        if (L == null) {
            return null;
        }
        return new IntList(L.data + x, creativeIncrement(L.next, x));
    }

    /**
     * Increments each element in the list by x using a destructive approach.
     *
     * @param L the list to be incremented
     * @param x the value to be added to each element in the list
     */
    private static IntList destructiveIncrement(IntList L, int x) {
        for(IntList p = L; p != null; p = p.next) {
            p.data += x;
        }
        return L;
    }

    // Main method to test the IntList class.
    public static void main(String[] args) {
        // create a list: 1->2->3->null
        IntList L = new IntList(1, new IntList(2, new IntList(3, null)));

        // test size methods
        System.out.println("Size: " + L.size()); // 3
        System.out.println("Recursive size: " + L.recursiveSize());
        System.out.println("Iterative size: " + L.iterativeSize());

        // test get methods
        System.out.println("Get(1): " + L.get(1)); // 2
        System.out.println("Recursive get(1): " + L.recursiveGet(1));
        System.out.println("Iterative get(1): " + L.iterativeGet(1));

        // test increment methods
        IntList L0 = increment(L, 1);
        System.out.println("After increment (1): " + L0);
        IntList L1 = creativeIncrement(L, 1);
        System.out.println("After creative increment (1): " + L1);
        System.out.println("Original list: " + L);
        IntList L2 = destructiveIncrement(L, 2);
        System.out.println("After destructive increment (2): " + L2);
        System.out.println("Original list: " + L);
    }
}

/**
 * IntList class represents a singly linked list of integers.
 *
 * @author SingularWind
 */
@SuppressWarnings("FieldMayBeFinal")
public class IntList {
    private int data;                       // data stored in this node
    private IntList next;                   // reference to the next node in the list
    public static final int LIMIT = 1000;   // threshold for using iterative method

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
        sb.append("IntList[");
        for (IntList p = this; p != null; p = p.next) {
            sb.append(p.data);
            if (p.next != null) {
                sb.append("->");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns the number of elements in this list using a recursive approach.
     *
     * @return the number of elements in this list
     */
    int recursiveSize() {
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
    int iterativeSize() {
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
    IntList recursiveGet(int index) {
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
    IntList iterativeGet(int index) {
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
    static IntList creativeIncrement(IntList L, int x) {
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
    static IntList destructiveIncrement(IntList L, int x) {
        for (IntList p = L; p != null; p = p.next) {
            p.data += x;
        }
        return L;
    }
}

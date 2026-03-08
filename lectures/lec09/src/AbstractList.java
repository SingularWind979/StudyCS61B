import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("unused")
abstract public class AbstractList<T> implements MyList<T> {
    protected int size; // number of elements in this list

    public AbstractList() {
        size = 0;
    }

    /**
     * Returns the number of items in the list.
     *
     * @return the number of items in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the given index is valid for this list.
     *
     * @param index the index to check
     * @throws IndexOutOfBoundsException if the index is not valid for this list
     */
    protected void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
        }
    }

    /**
     * Checks if the list is empty.
     *
     * @throws IllegalStateException if the list is empty
     */
    protected void checkEmptyList() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    }

    public void clear() {
        size = 0;
    }

    /**
     * Returns a new java.util.List containing the same items as this custom list.
     *
     * @return a new java.util.List containing the same items as this custom list
     */
    public List<T> toList() {
        List<T> result = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            result.add(get(i));
        }

        return result;
    }

    /**
     * Prints the string representation of this list to the standard output.
     */
    public void print() {
        System.out.println(this);
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getSimpleName());
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i < size - 1) {
                sb.append(connector());
            }
        }

        sb.append("]");

        return sb.toString();
    }

    /**
     * Compares this list to the specified object.
     *
     * @param obj   the reference object with which to compare.
     * @return true if this list is equal to the specified list
     */
    @Override
    public boolean equals(Object obj) {
        // false
        return false;
    }


    /**
     * Returns the connector character used in the string representation of this list.
     *
     * @return the connector character used in the string representation of this list
     */
    protected abstract String connector();
}

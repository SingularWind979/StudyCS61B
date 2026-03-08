import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * An implementation of MySet using an array.
 *
 * @param <T> the type of items in the set
 * @author SingularWind
 */
public class ASet<T> implements MySet<T> {
    /** The default capacity of this ArraySet. */
    private static final int DEFAULT_CAPACITY = 100;

    /** The array of items in this set. */
    @SuppressWarnings("FieldMayBeFinal")
    private T[] items;
    /** The number of items in this set. */
    private int size;

    /**
     * Constructs an empty ArraySet.
     */
    public ASet() {
        //noinspection unchecked
        items = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds item to this set if it is not already present.
     *
     * @param item the item to be added to this set
     */
    @Override
    public void add(T item) {
        if (!contains(item)) {
            items[size++] = item;
        }
    }

    /**
     * Removes item from this set if it is present.
     *
     * @param item the item to be removed from this set
     */
    @Override
    public void remove(T item) {
        if (contains(item)) {
            for (int i = indexOf(item); i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            items[--size] = null;
        }
    }

    /**
     * Returns true if this set contains item, false otherwise.
     *
     * @param item the item to be checked for presence in this set
     * @return true if this set contains item, false otherwise
     */
    @Override
    public boolean contains(Object item) {
        return indexOf(item) != -1;
    }

    /**
     * Returns the number of items in this set.
     *
     * @return the number of items in this set
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this set is empty, false otherwise.
     *
     * @return true if this set is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns a new ArrayList containing all items in this set, in the order they were added.
     *
     * @return a new ArrayList containing all items in this set, in the order they were added
     */
    @Override
    public List<T> toList() {
        return new ArrayList<>(Arrays.asList(items).subList(0, size));
    }

    /**
     * Returns the index of item in this set, or -1 if item is not present.
     *
     * @param item the item to be checked for presence in this set
     * @return the index of item in this set, or -1 if item is not present
     */
    private int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return pos < size;
            }

            @Override
            public T next() {
                return items[pos++];
            }
        };
    }

    /**
     * Returns a string representation of this set.
     *
     * @return a string representation of this set
     */
    @Override
    public String toString() {
        List<String> listOfItems = new ArrayList<>();

        for (T item : items) {
            listOfItems.add(item.toString());
        }

        return "ASet{" + String.join(", ", listOfItems) + "}";
    }

    /**
     * Compares this set with the specified object for equality.
     *
     * @param o   the reference object with which to compare.
     * @return true if this set is equal to the specified object, false otherwise
     */
    @Override
    public boolean equals(Object o) {
           // check identity
        if (this == o) {
            return true;
        }
        // check null
        if (o == null) {
            return false;
        }

        // check type
        if (o instanceof ASet<?> otherASet) {
            // check size
            if (size != otherASet.size) {
                return false;
            }
            // check items
            for (T item : this) {
                if (!otherASet.contains(item)) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}

package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractDeque61B<T> implements Deque61B<T> {
    /** The number of actual items in the deque. */
    protected int size;

    /**
     * Constructs a new empty deque.
     */
    public AbstractDeque61B() {
        size = 0;
    }

    /**
     * Returns if the deque is empty.
     * Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the deque.
     * Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a List copy of the deque.
     * Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();

        for (T item : this) {
            list.add(item);
        }

        return list;
    }

    /**
     * Returns an iterator for the deque.
     *
     * @return an iterator for the deque.
     */
    @Override
    @SuppressWarnings("NullableProblems")
    public abstract Iterator<T> iterator();

    /**
     * Returns if the deque is equal to the specified object.
     *
     * @param obj   the reference object with which to compare.
     * @return {@code true} if the deque is equal to the specified object, {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        // check if the object are the same
        if (obj == this) {
            return true;
        }

        // check if the type are same as Deque61B
        if (!(obj instanceof Deque61B<?> other)) {
            return false;
        }

        // check if the size of the deque are the same
        if (other.size() != this.size()) {
            return false;
        }

        // check if the elements in the deque are the same
        Iterator<?> otherIt = other.iterator();
        Iterator<?> thisIt = this.iterator();
        while (otherIt.hasNext() && thisIt.hasNext()) {
            if (!otherIt.next().equals(thisIt.next())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns a string representation of the deque.
     *
     * @return a string representation of the deque.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getClass().getSimpleName()).append("[");

        Iterator<T> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(",");
            }
        }

        sb.append("]");

        return sb.toString();
    }
}

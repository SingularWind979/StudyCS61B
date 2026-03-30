package deque;

import java.util.Comparator;

/**
 * A deque that can find the maximum element in the deque using a given comparator.
 *
 * @param <T> The type of elements in the deque.
 * @author SingularWind
 * @version 1.0
 */
public class MaxArrayDeque61B<T> extends ArrayDeque61B<T> {
    /** The default comparator to use for comparing elements. */
    private final Comparator<T> comparator;

    /**
     * Constructs a new MaxArrayDeque61B with the given comparator.
     *
     * @param comparator The comparator to use for comparing elements.
     */
    public MaxArrayDeque61B(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Finds the maximum element in the deque using the default comparator.
     *
     * @return The maximum element in the deque using the default comparator, or null if the deque is empty.
     * @throws NullPointerException If the comparator is null.
     */
    public T max() {
        return max(comparator);
    }

    /**
     * Finds the maximum element in the deque using the given comparator.
     *
     * @param otherComparator The comparator to use for comparing elements.
     * @return The maximum element in the comparator, or null if the deque is empty.
     * @throws NullPointerException If the comparator is null.
     */
    public T max(Comparator<T> otherComparator) {
        // check if the comparator is null
        if (otherComparator == null) {
            throw new NullPointerException("otherComparator is null");
        }

        // check if the deque is empty
        if (isEmpty()) {
            return null;
        }

        // find the maximum element
        T maxItem = getFirst();
        for (T item : this) {
            if (otherComparator.compare(maxItem, item) < 0) {
                maxItem = item;
            }
        }

        return maxItem;
    }
}

/**
 * Utility class for finding the maximum in an array of items.
 *
 * @author SingularWind
 */
public final class Maximizer {
    /**
     * Private constructor to prevent instantiation,
     * as this class is a utility class.
     */
    private Maximizer() {
    }

    /**
    * Finds the maximum item in the given array of items.
    *
    * @param items the array of items to find the maximum from.
    * @return the maximum item in the array.
    * @param <T> the type of items in the array, which must implement the
    *            Comparable interface.
    */
    public static <T extends Comparable<? super T>> T max(T[] items) {
        int maxIdx = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i].compareTo(items[maxIdx]) > 0) {
                maxIdx = i;
            }
        }

        return items[maxIdx];
    }
}

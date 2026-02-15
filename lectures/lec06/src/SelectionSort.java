/**
 * Sorts the input array using selection sort.
 *
 * @author SingularWind
 */
public class SelectionSort {
    /**
     * The threshold value for switching between iterative and recursive sorting.
     */
    private static final int THRESHOLD = 10000;

    /**
     * Sorts the input array using selection sort.
     *
     * @param input the array to be sorted
     */
    public static void sort(String[] input) {
        if (input == null || input.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }
        if (input.length >= THRESHOLD) {
            iterativeSort(input);
        } else {
            recursiveSort(input, 0);
        }
    }

    /**
     * Sorts the input array using selection sort iteratively.
     *
     * @param input the array to be sorted
     */
    private static void iterativeSort(String[] input) {
        for (int i = 0; i < input.length; i++) {
            int minIdx = findSmallest(input, i);
            swap(input, i, minIdx);
        }
    }

    /**
     * Sorts the input array using selection sort recursively.
     *
     * @param input the array to be sorted
     * @param start the index to start sorting from
     */
    private static void recursiveSort(String[] input, int start) {
        if (start >= input.length) {
            return;
        }
        int minIdx = findSmallest(input, start);
        swap(input, start, minIdx);
        recursiveSort(input, start + 1);
    }

    /**
     * Finds the index of the smallest element in the input array starting from the given index.
     *
     * @param input the array to search
     * @param start the index to start searching from
     * @return the index of the smallest element
     */
    public static int findSmallest(String[] input, int start) {
        int minIdx = start;
        for (int i = start; i < input.length; i++) {
            if (input[i].compareTo(input[minIdx]) < 0) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    /**
     * Swaps the elements at the given indices in the input array.
     *
     * @param input the array to swap elements in
     * @param idx1  the index of the first element to swap
     * @param idx2  the index of the second element to swap
     */
    public static void swap(String[] input, int idx1, int idx2) {
        String temp = input[idx1];
        input[idx1] = input[idx2];
        input[idx2] = temp;
    }
}

public final class Sort {
    /** Prevent instantiation */
    private Sort () {
        throw new UnsupportedOperationException("Cannot instantiate utility class Sort.");
    }

    /**
     * selection sort the {@code input} array
     * @param input an array of unsorted string
     * */
    public static void sort(String[] input) {
        sort(input, 0);
    }

    /**
     * selection sort the {@code input} array from the index of {@code start}
     * @param input an array of unsorted string
     * @param start sort from the {@code start} index in the array
     * */
    static void sort(String[] input, int start) {
        // base case (recursion)
        if (start == input.length) {
            return;
        }
        // find the smallest item of the rest
        int smallestIndex = findSmallest(input, start);
        // move it to the front
        swap(input, start, smallestIndex);
        // selection sort the rest (recursion)
        sort(input, start + 1);
    }

    /**
     * return the smallest string in the {@code input} array from the index of {@code start}
     * @param input  an array of unsorted string
     * @param start find the smallest from the {@code start} index in the array
     * */
    static int findSmallest(String[] input, int start) {
        int smallestIndex = start;
        for (int i = start; i < input.length; i++) {
            if (input[i].compareTo(input[smallestIndex]) < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /**
     * swap the {@code a}th and {@code b}th element in the {@code input} array
     * @param input an array of unsorted string
     * @param a swap location 1
     * @param b swap location 2
     */
    static void swap(String[] input, int a, int b) {
        String temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}

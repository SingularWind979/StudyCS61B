/**
 * Utility class for applying a function for many times.
 *
 * @author SingularWind
 */
public final class DoManyTimes {
    /** The threshold value for switching
     * between iterative and recursive approaches. */
    private static final int THRESHOLD = 5;

    /**
     * Private constructor to prevent instantiation,
     * as this class is a utility class.
     */
    private  DoManyTimes() {
    }

    /**
     * Applies the given function for a specified number of times.
     *
     * @param f The IntUnaryFunction to apply
     * @param x The initial value to apply the function to
     * @return The result after applying the function twice to 'x'
     */
    public static int doFuncTwice(IntUnaryFunction f, int x) {
        return doFunc(f, x, 2);
    }

    /**
    *  Applies the given function for a specified number of times.
     *
     * @param f The IntUnaryFunction to apply
     * @param x The initial value to apply the function to
     * @param t The number of times to apply the function
     * @return The result after applying the function 't' times to 'x'
     */
    public static int doFunc(IntUnaryFunction f, int x, int t) {
        checkTimes(t);

        if (t <= THRESHOLD) {
            return doFuncRecursive(f, x, t);
        } else  {
            return doFuncIterative(f, x, t);
        }
    }

    /**
     * Applies the given function for a specified number of times iteratively.
     *
     * @param f The IntUnaryFunction to apply
     * @param x The initial value to apply the function to
     * @param t The number of times to apply the function
     * @return The result after applying the function 't' times to 'x'
     */
    private static int doFuncIterative(IntUnaryFunction f, int x, int t) {
        for (int i = 0; i < t; i++) {
            x = f.apply(x);
        }

        return x;
    }

    /**
     * Applies the given function for a specified number of times recursively.
     *
     * @param f The IntUnaryFunction to apply
     * @param x The initial value to apply the function to
     * @param t The number of times to apply the function
     * @return The result after applying the function 't' times to 'x'
     */
    private static int doFuncRecursive(IntUnaryFunction f, int x, int t) {
        // edge case
        if (t == 0) {
            return x;
        }

        // recursive case
        return doFuncRecursive(f, f.apply(x), t - 1);
    }

    /**
     * Check if the times is non-negative.
     *
     * @param t The number of times to apply the function
     * @throws IllegalArgumentException if the times is negative
     */
    private static void checkTimes(int t) {
        if (t < 0) {
            throw new IllegalArgumentException("times must be non-negative");
        }
    }
}

/**
 * Wrap int to int function as a class.
 *
 * @author SingularWind
 */
public interface IntUnaryFunction {
    /**
     * Applies this function to the given argument.
     *
     * @param x the function argument
     * @return the function result
     */
    int apply(int x);
}

/**
 * Represents the function 2x.
 *
 * @author SingularwWind
 */
public class TwoX implements IntUnaryFunction {
    /**
     * Applies this function to the given argument.
     *
     * @param x the function argument
     * @return the function result
     */
    @Override
    public int apply(int x) {
        return 2 * x;
    }
}

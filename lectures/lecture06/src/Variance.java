/**
 * utility class
 * calculate the variance of an array of numbers
 * */
public final class Variance {
    /**
     * private the constructor of utility class Variance
     * */
    private Variance() {
        throw new UnsupportedOperationException("Cannot instantiate utility class Variance.");
    }

    /**
     * calculate the variance of an array of numbers
     * @param input a nonempty array of numbers
     * @return variance of the input array
     */
    public static double variance(double[] input) {
        // Determine the average of the list (denoted by mu).
        double mu = average(input);
        // For each item x in the list, compute (x − mu)2
        double[] newList = squaredDifference(input, mu);
        // Take the average of the squared differences.
        double variance = average(newList);

        return variance;
    }

    /**
     * calculate the average of an array of numbers
     * @param input a nonempty array of numbers
     * @return average of the input array
     * */
    static double average(double[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
        return sum / input.length;
    }

    /**
     * calculate squared difference for each item in an array of numbers
     * @param input an array of numbers
     * @param mu    the average of the input array
     * @return an array of squared differences of the input array
     * */
    static double[] squaredDifference(double[] input, double mu) {
        if (input == null || input.length == 0) {
            return new double[0];
        }

        double[] result = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            result[i] = (input[i] - mu) * (input[i] - mu);
        }
        return result;
    }
}
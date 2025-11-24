import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestVariance {
    @Test
    public void testVariance() {
        double[] input = {1, 2, 3, 4};
        double expected = 1.25;
        double actual = Variance.variance(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testVarianceSameElement() {
        double[] input = {1, 1, 1, 1, 1};
        double expected = 0;
        double actual = Variance.variance(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testVarianceEmptyList() {
        double[] input = {};
        double expected = 0;
        double actual = Variance.variance(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testVarianceNullList() {
        double[] input = null;
        double expected = 0;
        double actual = Variance.variance(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAverage() {
        double[] input = {1, 2, 3, 4};
        double expected = 2.5;
        double actual = Variance.average(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAverageSameElement() {
        double[] input = {1, 1, 1, 1, 1};
        double expected = 1;
        double actual = Variance.average(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAverageEmptyList() {
        double[] input = {};
        double expected = 0.0;
        double actual = Variance.average(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testAverageNullList() {
        double[] input = null;
        double expected = 0.0;
        double actual = Variance.average(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSquaredDifference() {
        double[] input = {1, 2, 3, 4};
        double[] expected = {2.25, 0.25, 0.25, 2.25};
        double mu = 2.5;
        double[] actual = Variance.squaredDifference(input, mu);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSquaredDifferenceEmptyList() {
        double[] input = {};
        double[] expected = {};
        double mu = 0.0;
        double[] actual = Variance.squaredDifference(input, mu);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSquaredDifferenceNullList() {
        double[] input = null;
        double[] expected = {};
        double mu = 0.0;
        double[] actual = Variance.squaredDifference(input, mu);
        assertThat(actual).isEqualTo(expected);
    }
}

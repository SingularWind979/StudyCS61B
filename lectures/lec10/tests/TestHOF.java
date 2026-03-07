import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests the HOFs in the DoManyTimes class.
 *
 * @author SingularWind
 */
public class TestHOF {
    @Test
    public void testTenX() {
        int input = 5;
        int expected = 10;

        int actual = new TwoX().apply(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDoTwice() {
        int x = 5;
        int expected = 20;

        int actual = DoManyTimes.doFuncTwice(new TwoX(), x);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testDoManyTimes() {
        int x = 5;

        for (int t = 1; t <= 6; t++) {
            int actual = DoManyTimes.doFunc(new TwoX(), x, t);
            int expected = (int) Math.pow(2, t) * x;
            assertThat(actual).isEqualTo(expected);
        }
    }
}

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests the SelectionSort class.
 */
public class TestSelectionSort {
    @Test
    public void testSort() {
        String[] input = {"CC", "BB", "DD", "AA"};
        String[] expected = {"AA", "BB", "CC", "DD"};
        SelectionSort.sort(input);
        assertThat(input).isEqualTo(expected);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"AA", "BB", "CC", "DD"};
        int expected = 1;
        int actual = SelectionSort.findSmallest(input, 1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testSwap() {
        String[] input = {"CC", "BB", "DD", "AA"};
        String[] expected = {"BB", "CC", "DD", "AA"};
        SelectionSort.swap(input, 0, 1);
        assertThat(input).isEqualTo(expected);
    }
}

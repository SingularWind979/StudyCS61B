import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertThat(input).isEqualTo(expected);
    }

    @Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int actual = Sort.findSmallest(input, 0);
        assertThat(actual).isEqualTo(expected);

        String[] input1 = {"there", "are", "many", "pigs"};
        int expected1 = 2;
        int actual1 = Sort.findSmallest(input1, 2);
        assertThat(actual1).isEqualTo(expected1);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 1;
        int b = 2;
        String[] expected = {"i", "an", "have", "egg"};
        Sort.swap(input, a, b);
        assertThat(input).isEqualTo(expected);
    }
}

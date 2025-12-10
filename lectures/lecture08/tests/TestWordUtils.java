import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests for utility class WordUtils
 *
 * @author Singularwind
 */
public class TestWordUtils {
    @Test
    @Order(0)
    @DisplayName("Test common situation")
    public void testLongest() {
        SLList<String> input = new SLList<>();
        input.addLast("a");
        input.addLast("bc");
        input.addLast("cde");
        String expected = "cde";
        String actual = WordUtils.longest(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Order(1)
    @DisplayName("Test empty list")
    public void testLongest2() {
        SLList<String> input = new SLList<>();
        String expected = "";
        String actual = WordUtils.longest(input);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Order(2)
    @DisplayName("Test same length strings")
    public void testLongest3() {
        SLList<String> input = new SLList<>();
        input.addLast("a");
        input.addLast("bc");
        input.addLast("cd");
        String expected = "bc";
        String actual = WordUtils.longest(input);
        assertThat(actual).isEqualTo(expected);
    }
}

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.truth.Truth.assertThat;

/**
 * Test class for the Maximizer utility class.
 *
 * @author SingularWind
 */
public class TestMaximizer {
    @Test
    public void testCustomMax() {
        Cat c1 = new Cat("a", 1);
        Cat c2 = new Cat("b", 2);
        Cat c3 = new Cat("c", 3);
        Cat[] input = {c1, c2, c3};

        Cat maxCat = Maximizer.max(input);

        assertThat(maxCat).isEqualTo(c3);
    }

    @Test
    public void testUtilMax() {
        Cat c1 = new Cat("a", 1);
        Cat c2 = new Cat("b", 2);
        Cat c3 = new Cat("c", 3);
        Cat[] input = {c1, c2, c3};

        Cat maxCat = Collections.max(Arrays.asList(input));

        assertThat(maxCat).isEqualTo(c3);
    }
}

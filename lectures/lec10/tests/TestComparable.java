import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
* Test class for the MyComparable interface.
 *
 * @author SingularWind
 */
public class TestComparable {
    @Test
    public void testCustomCompareTo() {
        Dog d1 = new Dog("a", 1);
        Dog d2 = new Dog("b", 2);

        int actual = d1.compareTo(d2);

        assertThat(actual).isEqualTo(-1);
    }

    @Test
    public void testUtilCompareTo() {
        Cat c1 = new Cat("a", 1);
        Cat c2 = new Cat("b", 2);

        int actual = c1.compareTo(c2);

        assertThat(actual).isEqualTo(-1);
    }
}

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestNameComparator {
    @Test
    public void testNameComparator() {
        Cat c1 = new Cat("a", 1);
        Cat c2 = new Cat("b", 2);

        int actual = Cat.nameComparator.compare(c1, c2);

        assertThat(actual).isEqualTo(-1);
    }
}

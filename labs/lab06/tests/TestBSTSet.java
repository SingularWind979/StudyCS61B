import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

/**
 * Basic tests for the BSTSet implementation.
 * Focuses on the "Set" property: uniqueness and existence.
 */
public class TestBSTSet {
    @Test
    public void testAddUniqueness() {
        Set61B<String> s = new BSTSet<>();
        // First insert should return the inserted element
        assertThat(s.insert("A")).isNotNull();
        // Subsequent identical inserts should return null
        assertThat(s.insert("A")).isNull();
        assertThat(s.insert("A")).isNull();

        // Final size must still be 1
        assertThat(s.size()).isEqualTo(1);
        assertThat(s.contains("A")).isTrue();
    }

    @Test
    public void testBasicOperations() {
        Set61B<Integer> s = new BSTSet<>();
        assertThat(s.isEmpty()).isTrue();

        s.insert(10);
        s.insert(20);
        s.insert(30);

        assertThat(s.size()).isEqualTo(3);
        assertThat(s.contains(20)).isTrue();
        assertThat(s.contains(40)).isFalse();

        // Verify delete returns the deleted element for existing items
        assertThat(s.delete(20)).isNotNull();
        assertThat(s.contains(20)).isFalse();
        assertThat(s.size()).isEqualTo(2);
    }

    @Test
    public void testClear() {
        Set61B<Double> s = new BSTSet<>();
        for (double d = 0.0; d < 10.0; d += 1.0) {
            s.insert(d);
        }
        assertThat(s.size()).isEqualTo(10);
        s.clear();
        assertThat(s.size()).isEqualTo(0);
        assertThat(s.isEmpty()).isTrue();
    }
}

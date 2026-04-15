import static org.junit.Assert.*;
import org.junit.Test;
import static com.google.common.truth.Truth.assertThat;

/**
 * Basic tests for the BST implementation.
 * Covers insertion, size tracking, and containment.
 */
public class TestBST {
    @SuppressWarnings("unused")
    @Test
    public void testGenerics() {
        try {
            OrderedTree<String> a = new BST<>();
            OrderedTree<Integer> b = new BST<>();
            OrderedTree<Double> c = new BST<>();
        } catch (Exception e) {
            fail("BST failed generic type initialization.");
        }
    }

    @Test
    public void testInsertAndSize() {
        OrderedTree<String> b = new BST<>();
        assertThat(b.size()).isEqualTo(0);

        // Test unique insert returns true
        assertThat(b.insert("hi")).isTrue();
        assertThat(b.size()).isEqualTo(1);

        // Test duplicate insert returns false
        assertThat(b.insert("hi")).isFalse();
        assertThat(b.size()).isEqualTo(1);

        for (int i = 0; i < 455; i++) {
            b.insert("val" + i);
        }
        assertThat(b.size()).isEqualTo(456);
    }

    @Test
    public void testContains() {
        OrderedTree<Integer> b = new BST<>();
        assertThat(b.contains(42)).isFalse();
        b.insert(42);
        assertThat(b.contains(42)).isTrue();
    }

    @Test
    public void testClear() {
        OrderedTree<Integer> b = new BST<>();
        for (int i = 0; i < 100; i++) {
            b.insert(i);
        }

        b.clear();
        assertThat(b.size()).isEqualTo(0);
        assertThat(b.isEmpty()).isTrue();
    }
}

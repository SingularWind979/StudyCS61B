import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;

/**
 * Advanced tests for BST structural integrity.
 * Focuses on Hibbard Deletion and Inorder Iterator behavior.
 */
public class TestBSTExtra {
    @Test
    public void testInorderIterator() {
        BST<String> b = new BST<>();
        String[] keys = {"d", "a", "c", "b", "e"};
        for (String k : keys) {
            b.insert(k);
        }

        List<String> result = new ArrayList<>();
        for (String k : b) {
            result.add(k);
        }

        // Must be in strictly increasing natural order
        assertThat(result).containsExactly("a", "b", "c", "d", "e").inOrder();
    }

    @Test
    public void testRemoveLeafAndOneChild() {
        BST<Integer> b = new BST<>();
        b.insert(50);
        b.insert(25);
        b.insert(75);
        b.insert(12); // Leaf of 25

        // Case 0: Remove leaf
        assertThat(b.delete(12)).isEqualTo(12);
        assertThat(b.contains(12)).isFalse();
        assertThat(b.size()).isEqualTo(3);

        // Case 1: Remove node with one child
        assertThat(b.delete(25)).isEqualTo(25);
        assertThat(b.contains(25)).isFalse();
        assertThat(b.contains(75)).isTrue();
        assertThat(b.size()).isEqualTo(2);
    }

    @Test
    public void testRemoveTwoChildrenHibbard() {
        BST<Integer> b = new BST<>();
        // Constructing a tree where 50 has two children
        int[] input = {50, 25, 75, 12, 37, 60, 90};
        for (int i : input) {
            b.insert(i);
        }

        // Case 2: Remove root (50) which has two children
        assertThat(b.delete(50)).isEqualTo(50);

        assertThat(b.contains(50)).isFalse();
        assertThat(b.size()).isEqualTo(6);

        // Critical: Ensure tree structure is preserved by checking inorder again
        List<Integer> result = new ArrayList<>();
        for (Integer i : b) {
            result.add(i);
        }
        assertThat(result).containsExactly(12, 25, 37, 60, 75, 90).inOrder();
    }

    @Test
    public void testDeleteNonExistent() {
        BST<Integer> b = new BST<>();
        b.insert(10);
        int initialSize = b.size();
        assertThat(b.delete(99)).isNull(); // Should not crash
        assertThat(b.size()).isEqualTo(initialSize);
    }
}

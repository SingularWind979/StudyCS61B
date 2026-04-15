import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static com.google.common.truth.Truth.assertThat;

/**
 * Advanced tests for BSTSet.
 * Focuses on ordering and structural integrity.
 */
public class TestBSTSetExtra {
    @Test
    public void testSortedIteration() {
        Set61B<Integer> s = new BSTSet<>();
        // Scrambled input
        int[] input = {40, 10, 50, 30, 20};
        for (int i : input) {
            s.insert(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int i : s) {
            result.add(i);
        }

        // The Delegation should ensure the BST's inorder iterator is used
        assertThat(result).containsExactly(10, 20, 30, 40, 50).inOrder();
    }

    @Test
    public void testComplexDelete() {
        Set61B<Character> s = new BSTSet<>();
        s.insert('B'); // Root
        s.insert('A'); // Left
        s.insert('C'); // Right

        // Delete root - checks if Delegation handles tree re-linking
        assertThat(s.delete('B')).isTrue();
        assertThat(s.contains('B')).isFalse();
        assertThat(s.size()).isEqualTo(2);

        // Ensure remaining elements are still reachable
        assertThat(s.contains('A')).isTrue();
        assertThat(s.contains('C')).isTrue();
    }

    @Test
    public void testDeleteMissing() {
        Set61B<String> s = new BSTSet<>();
        s.insert("Presence");
        // Deleting non-existent item should return false
        assertThat(s.delete("Absence")).isFalse();
        assertThat(s.size()).isEqualTo(1);
    }
}

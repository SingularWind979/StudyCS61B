import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BResizeTest {
    private static final int RESIZE_TEST_SCALE = 16;

    @Test
    void testAddFirstAndLastWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        // Test addFirst with resize
        for (int i = 0; i < RESIZE_TEST_SCALE / 2; i++) {
            deque.addFirst(i);
            list.addFirst(i);
        }

        assertThat(deque.toList()).
                containsExactlyElementsIn(list).
                inOrder();

        // Test addLast with resize
        for (int i = RESIZE_TEST_SCALE / 2; i < RESIZE_TEST_SCALE; i++) {
            deque.addLast(i);
            list.addLast(i);
        }

        assertThat(deque.toList()).
                containsExactlyElementsIn(list).
                inOrder();
    }

    @Test
    void testGetWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        // Test get with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addLast(i);
            list.addLast(i);
        }

        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            assertThat(deque.get(i)).isEqualTo(list.get(i));
        }

        // Test get with out-of-bounds index after resize
        assertThat(deque.get(RESIZE_TEST_SCALE * 2)).isNull();
    }

    @Test
    void testGetFirstAndLastWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        // Test getFirst with empty deque after resize
        assertThat(deque.getFirst()).isNull();
        assertThat(deque.getLast()).isNull();

        // Test getFirst and getLast with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addLast(i);
            list.addLast(i);
        }

        assertThat(deque.getFirst()).isEqualTo(list.getFirst());
        assertThat(deque.getLast()).isEqualTo(list.getLast());
    }

    @Test
    void testIsEmptyAndSizeWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        // Test isEmpty and size with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addLast(i);
            list.addLast(i);
        }

        assertThat(deque.isEmpty()).isEqualTo(list.isEmpty());
        assertThat(deque.size()).isEqualTo(list.size());
        assertThat(deque.toList()).
                containsExactlyElementsIn(list).
                inOrder();
    }

    @Test
    void testToListWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        // Test toList with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addLast(i);
            list.addLast(i);
        }

        assertThat(deque.toList()).
                containsExactlyElementsIn(list).
                inOrder();
    }

    @Test
    void testRemoveFirstAndLastWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addLast(i);
            list.addLast(i);
        }

        // Test removeFirst with non-empty deque after resize
        assertThat(deque.removeFirst()).isEqualTo(list.removeFirst());
        assertThat(deque.toList()).
                containsExactlyElementsIn(list).
                inOrder();

        // Test removeLast with non-empty deque after resize
        assertThat(deque.removeLast()).isEqualTo(list.removeLast());
        assertThat(deque.toList()).
            containsExactlyElementsIn(list).
            inOrder();
    }

    @Test
    void testAddsRemovesWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        // Test addLast with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addLast(i);
            list.addLast(i);
        }

        assertThat(deque.toList()).
                containsExactlyElementsIn(list).
                inOrder();

        // Test removeFirst with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            assertThat(deque.removeFirst()).isEqualTo(list.removeFirst());
        }

        // Test addFirst with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addFirst(i);
            list.addFirst(i);
        }

        assertThat(deque.toList()).
                containsExactlyElementsIn(list).
                inOrder();

        // Test removeLast with non-empty deque after resize
        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            assertThat(deque.removeLast()).isEqualTo(list.removeLast());
        }
    }
}

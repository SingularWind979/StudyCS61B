import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BBasicTest {
    private static final int BASIC_TEST_SCALE = 8;

    @Test
    @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
    void noNonTrivialFields() {
        List<Field> badFields = Reflection.getFields(ArrayDeque61B.class).
                filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic())).
                toList();

        assertWithMessage("Found fields that are not array or primitives").
                that(badFields).isEmpty();
    }

    @Test
    void testAddFirstAndLastBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        // Test addFirst
        for (int i = 0; i < BASIC_TEST_SCALE / 2; i++) {
            deque.addFirst(i);
        }
        assertThat(deque.toList()).
                containsExactly(3, 2, 1, 0).
                inOrder();

        // Test addLast
        for (int i = BASIC_TEST_SCALE / 2; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }
        assertThat(deque.toList()).
                containsExactly(3, 2, 1, 0, 4, 5, 6, 7).
                inOrder();
    }

    @Test
    void testGetBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        // Test get with empty deque
        assertThat(deque.get(0)).isNull();

        // Test get with non-empty deque
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
            assertThat(deque.get(i)).isEqualTo(i);
        }

        // Test get with out-of-bounds index
        assertThat(deque.get(BASIC_TEST_SCALE + 1)).isNull();
    }

    @Test
    void testGetFirstAndLastBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        // Test getFirst with empty deque
        assertThat(deque.getFirst()).isNull();
        assertThat(deque.getLast()).isNull();

        // Test getFirst and getLast with non-empty deque
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
            assertThat(deque.getFirst()).isEqualTo(0);
            assertThat(deque.getLast()).isEqualTo(i);
        }
    }


    @Test
    void testIsEmptyAndSizeBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        // Test isEmpty and size with empty deque
        assertThat(deque.isEmpty()).isTrue();
        assertThat(deque.size()).isEqualTo(0);

        // Test isEmpty and size with non-empty deque
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
            assertThat(deque.isEmpty()).isFalse();
            assertThat(deque.size()).isEqualTo(i + 1);
        }
    }

    @Test
    void testToListBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        // Test toList with empty deque
        assertThat(deque.toList()).isEmpty();

        // Test toList with non-empty deque
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
            list.add(i);
        }
            assertThat(deque.toList()).
                    containsExactlyElementsIn(list).
                    inOrder();
    }

    @Test
    void testRemoveFirstAndLastBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        // Test removeFirst and removeLast with empty deque
        assertThat(deque.removeFirst()).isNull();
        assertThat(deque.removeLast()).isNull();

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        // Test removeFirst
        for (int i = 0; i < BASIC_TEST_SCALE / 2; i++) {
            assertThat(deque.removeFirst()).isEqualTo(i);
        }

        // Test removeLast
        for (int i = 0; i < BASIC_TEST_SCALE / 2; i++) {
            assertThat(deque.removeLast()).isEqualTo(BASIC_TEST_SCALE - 1 - i);
        }
    }

    @Test
    void testAddsRemovesBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        // 1. Fill it up: [0, 1, 2, 3, 4, 5, 6, 7]
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        // 2. Verify: Check logical indices
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            assertThat(deque.get(i)).isEqualTo(i);
        }

        // 3. Empty it from the front: 0, 1, 2...
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            assertThat(deque.removeFirst()).isEqualTo(i);
        }

        // 4. Fill it from the front: [7, 6, 5, 4, 3, 2, 1, 0]
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addFirst(i);
        }

        // 5. Empty it from the back: 0, 1, 2... (LIFO behavior)
        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            assertThat(deque.removeLast()).isEqualTo(i);
        }

        // 6. Final Check: Deque is empty now.
        // Previous code tried to remove again here; that would return null.
        assertThat(deque.isEmpty()).isTrue();
    }
}

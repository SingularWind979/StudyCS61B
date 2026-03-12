import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest {
    private static final int BASIC_TEST_SCALE = 8;
    private static final int RESIZE_TEST_SCALE = 20;

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
    void testAddFirstBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addFirst(i);
        }

        assertThat(deque.toList()).
                containsExactly(7, 6, 5, 4, 3, 2, 1, 0).
                inOrder();
    }

    @Test
    void testAddLastBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        assertThat(deque.toList()).
                containsExactly(0, 1, 2, 3, 4, 5, 6, 7).
                inOrder();
    }

    @Test
    void testAddFirstAndLastBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        for (int i = 0; i < BASIC_TEST_SCALE / 2; i++) {
            deque.addFirst(i);
        }

        for (int i = BASIC_TEST_SCALE / 2; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        assertThat(deque.toList()).
                containsExactly(3, 2, 1, 0, 4, 5, 6, 7).
                inOrder();
    }

    @Test
    void testAddFirstAndLastWithResize() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        for (int i = 0; i < RESIZE_TEST_SCALE; i++) {
            deque.addFirst(i);
        }

        assertThat(deque.toList()).
                containsExactly(9, 8, 7, 6, 5, 4, 3, 2, 1, 0).
                inOrder();
    }

    @Test
    void testGetBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        assertThat(deque.get(0)).isNull();

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            assertThat(deque.get(i)).isEqualTo(i);
        }

        assertThat(deque.get(BASIC_TEST_SCALE + 1)).isNull();
    }

    @Test
    void testGetRecursiveBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        assertThat(deque.getRecursive(0)).isNull();

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            assertThat(deque.getRecursive(i)).isEqualTo(i);
        }

        assertThat(deque.getRecursive(BASIC_TEST_SCALE + 1)).isNull();
    }

    @Test
    void testGetFirstBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        assertThat(deque.getFirst()).isNull();

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        assertThat(deque.getFirst()).isEqualTo(0);
    }

    @Test
    void testGetLastBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        assertThat(deque.getLast()).isNull();

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        assertThat(deque.getLast()).isEqualTo(BASIC_TEST_SCALE - 1);
    }

    @Test
    void testIsEmptyAndSizeBasic() {
        Deque61B<Integer> deque = new ArrayDeque61B<>();

        assertThat(deque.isEmpty()).isTrue();
        assertThat(deque.size()).isEqualTo(0);

        for (int i = 0; i < BASIC_TEST_SCALE; i++) {
            deque.addLast(i);
        }

        assertThat(deque.isEmpty()).isFalse();
        assertThat(deque.size()).isEqualTo(BASIC_TEST_SCALE);
    }
}

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Performs some basic linked list tests.
 */
public class LinkedListDeque61BTest {
    @Test
    public void testAddFirstBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back");      // ["back"]
        lld1.addFirst("middle");    // ["middle", "back"]
        lld1.addFirst("front");     // ["front", "middle", "back"]

        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    public void testAddLastBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front");  // ["front"]
        lld1.addLast("middle"); // ["front", "middle"]
        lld1.addLast("back");   // ["front", "middle", "back"]

        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    public void testAddFirstAndAddLast() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    @Test
    public void testSizeAndIsEmptyWithAdd() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.size()).isEqualTo(0);
        assertThat(lld1.isEmpty()).isTrue();

        lld1.addLast(1);
        lld1.addLast(2);

        assertThat(lld1.size()).isEqualTo(2);
        assertThat(lld1.isEmpty()).isFalse();
    }

    @Test
    public void testSizeAndIsEmptyWithRemove() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.removeLast();
        lld1.removeLast();

        assertThat(lld1.size()).isEqualTo(0);
        assertThat(lld1.isEmpty()).isTrue();
    }
}

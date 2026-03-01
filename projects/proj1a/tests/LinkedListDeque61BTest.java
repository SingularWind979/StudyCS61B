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

        assertThat(lld1.size()).isEqualTo(2);
        assertThat(lld1.isEmpty()).isFalse();

        lld1.removeLast();
        lld1.removeLast();

        assertThat(lld1.size()).isEqualTo(0);
        assertThat(lld1.isEmpty()).isTrue();
    }

    @Test
    public void testGet() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.get(0)).isNull();

        lld1.addLast(1);
        lld1.addLast(2);    // 1,2

        assertThat(lld1.get(0)).isEqualTo(1);
        assertThat(lld1.get(1)).isEqualTo(2);
    }

    @Test
    public void testGetWithAdd() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addFirst(2);
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addFirst(5);   // 5,2,1,3,4

        assertThat(lld1.get(0)).isEqualTo(5);
        assertThat(lld1.get(1)).isEqualTo(2);
        assertThat(lld1.get(2)).isEqualTo(1);
    }

    @Test
    public void testGetWithRemove() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addLast(5);    // 1,2,3,4,5

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeFirst();     // 3,4

        assertThat(lld1.get(0)).isEqualTo(3);
        assertThat(lld1.get(1)).isEqualTo(4);
    }

    @Test
    public void testGetOutOfBounds() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);    // 1,2,3

        assertThat(lld1.get(-1)).isNull();
        assertThat(lld1.get(100)).isNull();
    }

    @Test
    public void testGetRecursiveBasic() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.get(0)).isNull();

        lld1.addLast(1);
        lld1.addLast(2);    // 1,2

        assertThat(lld1.getRecursive(0)).isEqualTo(1);
        assertThat(lld1.getRecursive(1)).isEqualTo(2);
    }

    @Test
    public void testGetRecursiveWithAdd() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addFirst(2);
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addFirst(5);   // 5,2,1,3,4

        assertThat(lld1.getRecursive(0)).isEqualTo(5);
        assertThat(lld1.getRecursive(1)).isEqualTo(2);
        assertThat(lld1.getRecursive(2)).isEqualTo(1);
    }

    @Test
    public void testGetRecursiveWithRemove() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);
        lld1.addLast(4);
        lld1.addLast(5);    // 1,2,3,4,5

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeFirst();   // 3,4

        assertThat(lld1.getRecursive(0)).isEqualTo(3);
        assertThat(lld1.getRecursive(1)).isEqualTo(4);
    }

    @Test
    public void testGetRecursiveOutOfBounds() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);

        assertThat(lld1.getRecursive(-1)).isNull();
        assertThat(lld1.getRecursive(100)).isNull();
    }

    @Test
    public void testGetFirst() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.getFirst()).isNull();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);    // 1,2,3

        assertThat(lld1.getFirst()).isEqualTo(1);
    }

    @Test
    public void testGetLast() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

        assertThat(lld1.getLast()).isNull();

        lld1.addLast(1);
        lld1.addLast(2);
        lld1.addLast(3);    // 1,2,3

        assertThat(lld1.getLast()).isEqualTo(3);
    }
}

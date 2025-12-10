import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * tests of ArrayDeque61B
 *
 * @author SingularWind
 */
public class ArrayDeque61BTest {
    @Test
    public void testToList() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertThat(ad.toList())
                .containsExactly(1, 2, 3)
                .inOrder();
    }

    @Test
    public void testIsEmptyTrue() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        assertThat(ad.isEmpty()).isTrue();
    }

    @Test
    public void testIsEmptyFalse() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        assertThat(ad.isEmpty()).isFalse();
    }

    @Test
    public void testSizeEmpty() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        assertThat(ad.size()).isEqualTo(0);
    }

    @Test
    public void testSizeNotEmpty() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertThat(ad.size()).isEqualTo(3);
    }

    @Test
    public void testSizeFull() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        for (int i = 0; i < ArrayDeque61B.INIT_CAPACITY; i++) {
            ad.addLast(i);
        }
        assertThat(ad.size()).isEqualTo(ArrayDeque61B.INIT_CAPACITY);
    }

    // TODO: for add and remove test empty, nearly empty, not empty, nearly full, full
    @Test
    public void testAddFirst() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addFirst(1);
        ad.addFirst(2);
        ad.addFirst(3);
        assertThat(ad.toList())
                .containsExactly(3, 2, 1)
                .inOrder();
    }

    @Test
    public void testAddLast() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertThat(ad.toList())
                .containsExactly(1, 2, 3)
                .inOrder();

    }

    // TODO: for gets, valid and invalid index (OOB, neg)
    @Test
    public void testGet() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertThat(ad.get(1)).isEqualTo(2);
    }

    @Test
    public void testGetRecursive() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        assertThat(ad.getRecursive(1)).isEqualTo(2);
    }


    @Test
    public void testRemoveFirst() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.removeFirst();
        assertThat(ad.toList())
                .containsExactly(2, 1)
                .inOrder();
    }

    @Test
    public void testRemoveLast() {
        Deque61BB<Integer> ad = new ArrayDeque61B<>();
        ad.addLast(1);
        ad.addLast(2);
        ad.addLast(3);
        ad.removeLast();
        assertThat(ad.toList())
                .containsExactly(1, 2)
                .inOrder();
    }

//    @Test
//    public void testResizeUp() {
//    }
//
//    @Test
//    public void testResizeDown() {
//    }
}

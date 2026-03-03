import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Test class to test the SLList class.
 */
public class TestSLList {
    @Test
    public void testGet() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertThat(list.get(0)).isEqualTo(10);
        assertThat(list.get(1)).isEqualTo(20);
        assertThat(list.get(2)).isEqualTo(30);
    }

    @Test
    public void testInsert() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.insert(15, 1);

        assertThat(list.toList()).containsExactly(10, 15, 20, 30).inOrder();
    }

    @Test
    public void testRemove() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.remove(1);

        assertThat(list.toList()).containsExactly(10, 30).inOrder();
    }

    @Test
    public void testGetFirst() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertThat(list.getFirst()).isEqualTo(10);
    }

    @Test
    public void testGetLast() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertThat(list.getLast()).isEqualTo(30);
    }

    @Test
    public void testAddFirst() {
        SLList<Integer> list = new SLList<>();

        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        assertThat(list.toList()).containsExactly(30, 20, 10).inOrder();
    }

    @Test
    public void testAddLast() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertThat(list.toList()).containsExactly(10, 20, 30).inOrder();
    }

    @Test
    public void testRemoveFirst() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.removeFirst();

        assertThat(list.toList()).containsExactly(20, 30).inOrder();
    }

    @Test
    public void testRemoveLast() {
        SLList<Integer> list = new SLList<>();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.removeLast();

        assertThat(list.toList()).containsExactly(10, 20).inOrder();
    }

    @Test
    public void testSizeAndIsEmpty() {
        SLList<Integer> list = new SLList<>();

        assertThat(list.size()).isEqualTo(0);
        assertThat(list.isEmpty()).isTrue();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.isEmpty()).isFalse();
    }
}

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests the addLast and size methods of the AList class.
 *
 * @author SingularWind
 */
public class TestAList {

    @Test
    public void testAddLastAndSize() {
        AList<Integer> list = new AList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        assertThat(list.size()).isEqualTo(3);
        assertThat(list.getLast()).isEqualTo(30);
    }

    @Test
    public void testRemoveLastAndSize() {
        AList<String> list = new AList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        String removed = list.removeLast();

        assertThat(removed).isEqualTo("C");
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.getLast()).isEqualTo("B");
    }

    @Test
    public void testResizingUp() {
        AList<Integer> list = new AList<>();
        for (int i = 0; i < 150; i++) {
            list.addLast(i);
        }

        assertThat(list.size()).isEqualTo(150);
        assertThat(list.getLast()).isEqualTo(149);
    }

    @Test
    public void testResizingDown() {
        AList<Integer> list = new AList<>();
        for (int i = 0; i < 200; i++) {
            list.addLast(i);
        }

        for (int i = 0; i < 190; i++) {
            list.removeLast();
        }

        assertThat(list.size()).isEqualTo(10);
        assertThat(list.getLast()).isEqualTo(9);
    }
}
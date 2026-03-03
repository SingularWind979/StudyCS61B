import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Test class for RotatingSLList.
 *
 * @author SingularWind
 */
public class TestRotatingSLList {
    @Test
    public void testRotateRight() {
        RotatingSLList<Integer> list = new RotatingSLList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.rotateRight();

        assertThat(list.toList()).containsExactly(5, 1, 2, 3, 4).inOrder();
    }

    @Test
    public void testRotateLeft() {
        RotatingSLList<Integer> list = new RotatingSLList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.rotateLeft();

        assertThat(list.toList()).containsExactly(2, 3, 4, 5, 1).inOrder();
    }
}

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Test class for VengefulSLList.
 *
 * @author SingularWind
 */
public class TestVengefulSLList {
    @Test
    public void testRemovedItems() {
        VengefulSLList<Integer> list = new VengefulSLList<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        assertThat(list.RemovedItems().toList()).containsExactly(1, 2, 3).inOrder();
    }
}

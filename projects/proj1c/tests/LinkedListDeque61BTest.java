import deque.LinkedListDeque61B;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class LinkedListDeque61BTest {
    private static final int TEST_SCALE = 16;

    @Test
    public void testIteratorBasic() {
        LinkedListDeque61B<Integer> lld = new LinkedListDeque61B<>();

        for (int i = 0; i < TEST_SCALE; i++) {
            lld.addLast(i);
        }

        assertThat(lld).
                containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).
                inOrder();
    }

    @Test
    public void testToListBasic() {
        LinkedListDeque61B<Integer> lld = new LinkedListDeque61B<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < TEST_SCALE; i++) {
            lld.addLast(i);
            list.add(i);
        }

        assertThat(lld.toList()).containsExactlyElementsIn(list);
    }

    @Test
    public void testToStringBasic() {
        LinkedListDeque61B<Integer> lld = new LinkedListDeque61B<>();
        StringBuilder sb = new StringBuilder();

        sb.append("LinkedListDeque61B[");

        for (int i = 0; i < TEST_SCALE; i++) {
            lld.addLast(i);
            sb.append(i).append(",");
        }
        sb.setLength(sb.length() - 1);

        sb.append("]");

        assertThat(lld.toString()).isEqualTo(sb.toString());
    }

    @Test
    public void testEqualsBasic() {
        LinkedListDeque61B<Integer> lld1 = new LinkedListDeque61B<>();
        LinkedListDeque61B<Integer> lld2 = new LinkedListDeque61B<>();

        assertThat(lld1).isEqualTo(lld2);

        for (int i = 0; i < TEST_SCALE; i++) {
            lld1.addLast(i);
        }

        assertThat(lld1).isNotEqualTo(lld2);

        for (int i = 0; i < TEST_SCALE; i++) {
            lld2.addLast(i);
        }

        assertThat(lld1).isEqualTo(lld2);
    }
}

import deque.ArrayDeque61B;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ArrayDeque61BTest {
    private static final int TEST_SCALE = 16;

    @Test
    public void testIteratorBasic() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();

        for (int i = 0; i < TEST_SCALE; i++) {
            ad.addLast(i);
        }

        assertThat(ad).
                containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15).
                inOrder();
    }

    @Test
    public void testToListBasic() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < TEST_SCALE; i++) {
            ad.addLast(i);
            list.add(i);
        }

        assertThat(ad.toList()).containsExactlyElementsIn(list);
    }

    @Test
    public void testToStringBasic() {
        ArrayDeque61B<Integer> ad = new ArrayDeque61B<>();
        StringBuilder sb = new StringBuilder();

        sb.append("ArrayDeque61B[");

        for (int i = 0; i < TEST_SCALE; i++) {
            ad.addLast(i);
            sb.append(i).append(",");
        }
        sb.setLength(sb.length() - 1);

        sb.append("]");

        assertThat(ad.toString()).isEqualTo(sb.toString());
    }

    @Test
    public void testEqualsBasic() {
        ArrayDeque61B<Integer> ad1 = new ArrayDeque61B<>();
        ArrayDeque61B<Integer> ad2 = new ArrayDeque61B<>();

        assertThat(ad1).isEqualTo(ad2);

        for (int i = 0; i < TEST_SCALE; i++) {
            ad1.addLast(i);
        }

        assertThat(ad1).isNotEqualTo(ad2);

        for (int i = 0; i < TEST_SCALE; i++) {
            ad2.addLast(i);
        }

        assertThat(ad1).isEqualTo(ad2);
    }
}

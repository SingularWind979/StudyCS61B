import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests the ArraySet class.
 *
 * @author SingularWind
 */
public class TestASet {
    @Test
    public void testSizeAndIsEmpty() {
        MySet<Integer> set = new ASet<>();

        assertThat(set.size()).isEqualTo(0);
        assertThat(set.isEmpty()).isTrue();

        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.size()).isEqualTo(3);
        assertThat(set.isEmpty()).isFalse();

        set.remove(3);
        set.remove(4);
        set.remove(5);

        assertThat(set.size()).isEqualTo(2);
        assertThat(set.isEmpty()).isFalse();

        set.remove(1);
        set.remove(2);
        assertThat(set.size()).isEqualTo(0);
        assertThat(set.isEmpty()).isTrue();
    }

    @Test
    public void testAdd() {
        MySet<Integer> set = new ASet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.toList()).containsExactly(1, 2, 3);

        set.add(3);
        set.add(4);

        assertThat(set.toList()).containsExactly(1, 2, 3, 4);
    }

    @Test
    public void testRemove() {
        MySet<Integer> set = new ASet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        set.remove(1);

        assertThat(set.toList()).containsExactly(2, 3);

        set.remove(1);
        set.remove(2);

        assertThat(set.toList()).containsExactly(3);
    }

    @Test
    public void testContains() {
        MySet<Integer> set = new ASet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        assertThat(set.contains(1)).isTrue();
        assertThat(set.contains(10)).isFalse();
    }

    @Test
    public void testForEachLoop() {
        MySet<Integer> set = new ASet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        List<Integer> list = set.toList();

        for (int i : set) {
            assertThat(i).isIn(list);
        }
    }

    @SuppressWarnings("WhileLoopReplaceableByForEach")
    @Test
    public void testIterator() {
        MySet<Integer> set = new ASet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        List<Integer> list = set.toList();

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            assertThat(i).isIn(list);
        }
    }

    @SuppressWarnings("EqualsWithItself")
    @Test
    public void testEquals() {
        MySet<Integer> set1 = new ASet<>();

        assertThat(set1.equals(set1)).isTrue();

        MySet<Integer> set2 = new ASet<>();

        assertThat(set1.equals(set2)).isTrue();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        assertThat(set1.equals(set2)).isFalse();

        set2.add(3);
        set2.add(2);
        set2.add(1);

        assertThat(set1.equals(set2)).isTrue();
    }
}

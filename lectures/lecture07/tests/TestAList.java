import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the AList class
 * @author Josh Hug
 */

public class TestAList {
    @Test
    public void testEmptySize() {
        AList<Integer> L = new AList<>();
        assertEquals(0, L.size());
    }

    @Test
    public void testAddAndSize() {
        AList<Integer> L = new AList<>();
        L.addLast(99);
        L.addLast(99);
        assertEquals(2, L.size());
    }

    @Test
    public void testAddAndGetLast() {
        AList<Integer> L = new AList<>();
        L.addLast(99);
        assertEquals(99, L.getLast().intValue());
        L.addLast(36);
        assertEquals(36, L.getLast().intValue());
    }

    @Test
    public void testGet() {
        AList<Integer> L = new AList<>();
        L.addLast(99);
        assertEquals(99, L.get(0).intValue());
        L.addLast(36);
        assertEquals(99, L.get(0).intValue());
        assertEquals(36, L.get(1).intValue());
    }

    @Test
    public void testRemove() {
        AList<Integer> L = new AList<>();
        L.addLast(99);
        assertEquals(99, L.get(0).intValue());
        L.addLast(36);
        assertEquals(99, L.get(0).intValue());
        L.removeLast();
        assertEquals(99, L.getLast().intValue());
        L.addLast(100);
        assertEquals(100, L.getLast().intValue());
        assertEquals(2, L.size());
    }

    /** Tests insertion of a large number of items.*/
    @Test
    public void testMegaInsert() {
        AList<Integer> L = new AList<>();
        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            L.addLast(i);
        }

        for (int i = 0; i < N; i += 1) {
            L.addLast(L.get(i));
        }
    }
}


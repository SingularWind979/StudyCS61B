import static org.junit.Assert.*;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests the {@link BSTMap} class with basic methods.
 *
 * @author Brendan Hu, Josh Hug, Noah Adhikari
 */
public class TestBSTMap {
    /**
     * Tests the generics of the class.
     */
    @SuppressWarnings("unused")
    @Test
    public void testGenerics() {
        try {
            Map61B<String, String> a = new BSTMap<>();
            Map61B<String, Integer> b = new BSTMap<>();
            Map61B<Integer, String> c = new BSTMap<>();
            Map61B<Boolean, Integer> e = new BSTMap<>();
        } catch (Exception e) {
            fail();
        }
    }

    /**
     * Tests the {@code put()} method.
     * Assumes {@code get()} and {@code containsKey()}
     * are implemented properly.
     */
    @Test
    public void testPutBasic() {
        Map61B<String, Integer> b = new BSTMap<>();
        b.put("hi", 1);
        assertThat(b.containsKey("hi")).isTrue();
        assertThat(b.get("hi")).isEqualTo(1);
    }

    /**
     * Tests the {@code get()} method.
     * Assumes {@code put()} is implemented properly.
     */
    @Test
    public void testGetBasic() {
        Map61B<String, Integer> b = new BSTMap<>();
        assertThat(b.get("starChild")).isNull();
        assertThat(b.size()).isEqualTo(0);
        b.put("starChild", 5);
        assertThat(b.get("starChild")).isEqualTo(5);
        assertThat(b.size()).isEqualTo(1);
        b.put("KISS", 5);
        assertThat(b.get("KISS")).isEqualTo(5);
        assertThat(b.get("starChild")).isNotNull();
        assertThat(b.size()).isEqualTo(2);
    }

    /**
     * Tests the {@code containsKey()} method.
     * Assumes {@code put()} is implemented properly.
     */
    @Test
    public void testContainsKeyBasic() {
        Map61B<String, Integer> b = new BSTMap<>();
        assertThat(b.containsKey("waterYouDoingHere")).isFalse();
        b.put("waterYouDoingHere", 0);
        assertThat(b.containsKey("waterYouDoingHere")).isTrue();
    }

    /**
     * Tests the {@code containsKey()} method.
     * Assumes {@code put()} is implemented properly.
     * Remembers that {@code containsKey()}
     * should only care about the keys, not the values!
     */
    @Test
    public void testContainsKeyContainsNull() {
        Map61B<String, Integer> b = new BSTMap<>();
        b.put("hi", null);
        assertThat(b.get("hi")).isNull();
        assertThat(b.containsKey("hi")).isTrue();
    }


    /**
     * Tests the {@code size()} method.
     * Assumes {@code put()} is implemented properly.
     */
    @Test
    public void testSizeBasic() {
        Map61B<String, Integer> b = new BSTMap<>();
        assertThat(b.size()).isEqualTo(0);
        b.put("hi", 1);
        assertThat(b.size()).isEqualTo(1);
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);
        }
        assertThat(b.size()).isEqualTo(456);
    }


    /**
     * Tests the {@code clear()} method.
     * Assumes {@code put()} / {@code size()} /
     * {@code containsKey()} / {@code get()}
     * are implemented properly.
     */
    @Test
    public void testClearBasic() {
        Map61B<String, Integer> b = new BSTMap<>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1 + i);
            //make sure put is working via containsKey and get
            assertThat(b.get("hi" + i)).isEqualTo(1 + i);
            assertThat(b.containsKey("hi" + i)).isTrue();
        }
        assertThat(b.size()).isEqualTo(455);
        b.clear();
        assertThat(b.size()).isEqualTo(0);
        for (int i = 0; i < 455; i++) {
            assertThat(b.get("hi" + i)).isNull();
            assertThat(b.containsKey("hi" + i)).isFalse();
        }
    }

    /**
     * Tests the tree.
     */
    @Test
    public void testTree() {
        Map61B<String, String> b = new BSTMap<>();
        b.put("d", "parmesan");
        b.put("a", "mozzarella");
        b.put("c", "swiss");
        b.put("b", "pepper jack");
        b.put("e", "gouda");

        assertThat(b.size()).isEqualTo(5);
        assertThat(b.get("d")).isEqualTo("parmesan");
        assertThat(b.get("a")).isEqualTo("mozzarella");
        assertThat(b.get("c")).isEqualTo("swiss");
        assertThat(b.get("b")).isEqualTo("pepper jack");
        assertThat(b.get("e")).isEqualTo("gouda");

        b.put("b", "provolone");
        assertThat(b.size()).isEqualTo(5);
        assertThat(b.get("b")).isEqualTo("provolone");
    }
}

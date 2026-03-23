import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Test class for DisjointSetUnion.
 *
 * @author SingularWind
 */
public class TestDisjointSetUnionBasic {
    private final int BASIC_SIZE = 8;
    @Test
    public void testDisjointSetUnionBasic() {
        DisjointSet ds = new DisjointSetUnion(BASIC_SIZE);

        // test isConnected
        for (int i = 0; i < BASIC_SIZE; i++) {
            for (int j = 0; j < BASIC_SIZE; j++) {
                if (i == j) {
                    assertThat(ds.isConnected(i, j)).isTrue();
                } else {
                    assertThat(ds.isConnected(i, j)).isFalse();
                }
            }
        }
    }

    @Test
    public void testConnectAndIsConnected() {
        DisjointSet ds = new DisjointSetUnion(BASIC_SIZE);

        assertThat(ds.isConnected(0, 1)).isFalse();
        ds.connect(0, 1);
        assertThat(ds.isConnected(0, 1)).isTrue();

        assertThat(ds.isConnected(2, 3)).isFalse();
        ds.connect(2, 3);
        assertThat(ds.isConnected(2, 3)).isTrue();

        assertThat(ds.isConnected(0, 3)).isFalse();
        ds.connect(1, 2);
        assertThat(ds.isConnected(0, 3)).isTrue();

        assertThat(ds.isConnected(0, 7)).isFalse();
        ds.connect(3, 4);
        ds.connect(4, 5);
        ds.connect(5, 6);
        ds.connect(6, 7);
        assertThat(ds.isConnected(0, 7)).isTrue();
    }
}

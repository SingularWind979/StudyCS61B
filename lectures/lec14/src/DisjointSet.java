/**
 * Disjoint set interface.
 *
 * @author SingularWind
 */
public interface DisjointSet {
    /**
     * Connects the two sets that contain p and q.
     *
     * @param p The first element.
     * @param q The second element.
     */
    void connect(int p, int q);

    /**
     * Returns true if p and q are in the same set.
     *
     * @param p The first element.
     * @param q The second element.
     * @return True if p and q are in the same set, false otherwise.
     */
    boolean isConnected(int p, int q);
}

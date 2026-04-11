/**
 * DisjointSets interface
 * Represents a collection of disjoint sets,
 * with dynamic set union and find operations.
 *
 * @author SingularWind
 */
public interface DisjointSets {
    /**
     * Returns true if nodes/vertices V1 and V2 are connected.
     *
     * @param v1 the first item to check if it is connected to V2
     * @param v2 the second item to check if it is connected to V1
     * @return true if V1 and V2 are connected, false otherwise
     */
    boolean connected(int v1, int v2);

    /**
     * Connects two items V1 and V2 together by connecting their respective sets.
     * V1 and V2 can be any element,
     * and a union-by-size heuristic is used.
     * If the sizes of the sets are equal,
     * tie-break by connecting V1's root to V2's root.
     * Union-ing an item with itself
     * or items that are already connected should not change the structure.
     *
     * @param v1 the first item to connect
     * @param v2 the second item to connect
     */
    void union(int v1, int v2);

    /**
     * Returns the root of the set V belongs to.
     * Path-compression is employed to speed up future find operations.
     *
     * @param v the item to find the root of
     * @return the root of the set V belongs to
     */
    int find(int v);
}

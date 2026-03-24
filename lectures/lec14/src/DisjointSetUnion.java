/**
 * DisjointSetUnion implements DisjointSet interface.
 *
 * @author SingularWind
 */
public class DisjointSetUnion implements DisjointSet {
    /**
     * if i == root,
     * parentOf[root] is negative to mark this is root,
     * abs(parentOf[root]) stores the weight of the set,
     * otherwise, parentOf[i] stores the parent of i
     */
    private final int[] parent;

    /**
     * Constructs a new DisjointSetUnion with the specified capacity.
     * Each element is initially in its own set.
     *
     * @param capacity The capacity of the DisjointSetUnion.
     */
    public DisjointSetUnion(int capacity) {
        parent = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            parent[i] = -1;
        }
    }

    /**
     * Connects the two sets that contain p and q.
     *
     * @param p The first element.
     * @param q The second element.
     */
    @Override
    public void connect(int p, int q) {
        // find the roots of p and q
        int rootP = rootOf(p);
        int rootQ = rootOf(q);

        // if p and q are in the same set, do nothing
        if (rootP == rootQ) {
            return;
        }

        // merge the two sets,
        // the light set is merged into the heavy set.
        int weightP = weightOf(p);
        int weightQ = weightOf(q);
        int heavyRoot = weightP > weightQ ? rootP : rootQ;
        int lightRoot = rootP + rootQ - heavyRoot;
        parent[heavyRoot] += parent[lightRoot];
        parent[lightRoot] = heavyRoot;
    }

    /**
     * Returns true if p and q are in the same set.
     *
     * @param p The first element.
     * @param q The second element.
     * @return True if p and q are in the same set, false otherwise.
     */
    @Override
    public boolean isConnected(int p, int q) {
        return rootOf(p) == rootOf(q);
    }

    /**
     * Returns true if p is the root of the set that contains p.
     *
     * @param p The element.
     * @return True if p is the root of the set that contains p, false otherwise.
     */
    private boolean isRoot(int p) {
        return parent[p] < 0;
    }

    /**
     * Returns the root of the set that contains p.
     *
     * @param p The element.
     * @return The root of the set that contains p.
     */
    private int rootOf(int p) {
        // edge case
        if (isRoot(p)) {
            return p;
        }

        // recursive case
        int root = rootOf(parent[p]);
        // path compression while recursion
        parent[p] = root;
        // continue the recursion
        return root;
    }

    /**
     * Returns the weight of the set that contains p.
     *
     * @param p The element.
     * @return The weight of the set that contains p.
     */
    private int weightOf(int p) {
        return Math.abs(rootOf(p));
    }
}

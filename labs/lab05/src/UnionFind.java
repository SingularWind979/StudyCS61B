/**
 * UnionFind data structure
 * for quick set union and find.
 *
 * @author 61B Staff + SingularWind
 */
public class UnionFind implements DisjointSets {
    /**
     * Stores the parent pointer of each item,
     * negative value marks the node is a root,
     * and the absolute value is the size of the tree.
     * For root node, {@code parent[root]} is the negative size of the tree.
     * For normal node, {@code parent[node]} is the parent of node.
     */
    private final int[] parents;

    /**
     * Creates a UnionFind data structure holding {@code N} items.
     * Initially, all items are in disjoint sets.
     *
     * @param N the number of items in the UnionFind data structure
     */
    public UnionFind(int N) {
        // Check if N is valid
        if (N < 0) {
            throw new IllegalArgumentException("");
        }

        // A fixed size array
        parents = new int[N];

        // Initialize all items as root nodes
        for (int i = 0; i < N; i++) {
            parents[i] = -1;
        }
    }

    /**
     * Returns true if nodes/vertices {@code v1} and {@code v2} are connected.
     * Assumes {@code v1} and {@code v2} are valid.
     *
     * @param v1 the first item to check if it is connected to {@code v2}
     * @param v2 the second item to check if it is connected to {@code v1}
     * @return true if {@code v1} and {@code v2} are connected, false otherwise
     */
    public boolean connected(int v1, int v2) {
        // Check if the vertices are valid
        checkVertex(v1);
        checkVertex(v2);

        return find(v1) == find(v2);
    }

    /**
     * Connects two items {@code v1} and {@code v2} together by connecting their respective sets.
     * {@code v1} and {@code v2} can be any element,
     * and a union-by-size heuristic is used.
     * If the sizes of the sets are equal,
     * tie-break by connecting {@code v1}'s root to {@code v2}'s root.
     * Union-ing an item with itself or items that are already connected
     * should not change the structure.
     * Assumes {@code v1} and {@code v2} are valid.
     *
     * @param v1 the first item to connect
     * @param v2 the second item to connect
     */
    public void union(int v1, int v2) {
        // Check if the vertices are valid
        checkVertex(v1);
        checkVertex(v2);

        //
        if (connected(v1, v2)) {
            return;
        }

        // Find the roots of the two items
        int root1 = rootOf(v1);
        int root2 = rootOf(v2);

        // Get the sizes of the two sets
        int size1 = sizeOf(root1);
        int size2 = sizeOf(root2);

        // Find the small root and big root
        int smallRoot;
        int bigRoot;
        if (size1 <= size2) {
            smallRoot = root1;
            bigRoot = root2;
        } else {
            smallRoot = root2;
            bigRoot = root1;
        }


        // Union by-size, small root points to big root
        setParent(smallRoot, bigRoot);
        setSize(bigRoot, size1 + size2);
    }

    /**
     * Returns the root of the set {@code v} belongs to.
     * Path-compression is employed to speed up future find operations.
     * Assumes {@code v} is valid.
     *
     * @param v the item to find the root of
     * @return the root of the set {@code v} belongs to
     */
    public int find(int v) {
        // Check if the vertex is valid
        checkVertex(v);

        return rootOf(v);
    }

    /**
     * Returns true if {@code v} is the root of a tree.
     *
     * @param v the item to check if it is the root of a tree
     * @return true if {@code v} is the root of a tree, false otherwise
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isRoot(int v) {
        return parents[v] < 0;
    }

    /**
     * Returns the root of the set {@code v} belongs to.
     *
     * @param v the item to find the root of
     * @return the root of the set {@code v} belongs to
     */
    private int rootOf(int v) {
        // Iterate to find the root of the tree
        int current;
        for (current = v; !isRoot(current); current = parentOf(current)) {
            // Path compression by halving
            // if current does have grandparent, set its parent to grandparent
            if (!isRoot(parentOf(current))) {
                setParent(current, parentOf(parentOf(current)));
            }
        }

        return current;
    }

    /**
     * Returns the size of the set {@code v} belongs to.
     * Assumes {@code v} is the root of a tree.
     *
     * @param root the item to find the size of the set
     * @return the size of the set {@code root} belongs to
     */
    private int sizeOf(int root) {
        return Math.abs(parents[root]);
    }

    /**
     * Returns the parent of {@code v}.
     * Assumes {@code v} is not the root of a tree.
     *
     * @param v the item to find the parent of
     * @return the parent of {@code v}
     */
    private int parentOf(int v) {
        return parents[v];
    }

    /**
     * Sets the size of the set {@code root} belongs to {@code size}.
     * Assumes {@code root} is the root of a tree.
     *
     * @param root the item to set the size of the set
     * @param size the size of the set {@code root} belongs to
     */
    private void setSize(int root, int size) {
        parents[root] = -size;
    }

    /**
     * Sets the parent of {@code v} to {@code parent}.
     * If {@code v} and {@code parent} are roots,
     * that means a smaller root is connected to a bigger root.
     *
     * @param v the item to set the parent of
     * @param parent the parent of {@code v}
     */
    private void setParent(int v, int parent) {
        parents[v] = parent;
    }

    /**
     * Returns true if {@code v} is a valid vertex.
     *
     * @param v the vertex to check if it is valid
     * @return true if {@code v} is a valid vertex, false otherwise
     */
    private boolean isValidVertex(int v) {
        return v >= 0 && v < parents.length;
    }

    /**
     * Checks if {@code v} is a valid vertex.
     *
     * @param v the vertex to check if it is valid
     */
    private void checkVertex(int v) {
        if (!isValidVertex(v)) {
            throw new IllegalArgumentException("Vertex " + v + " is not valid");
        }
    }
}

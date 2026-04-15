import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Binary Search Tree (BST) implementation:
 * A binary ordered tree that maintains elements in a specific order.
 *
 * @param <K> the type of elements maintained by this BST,
 * must be {@link Comparable}
 *
 * @author SingularWind
 */
public class BST<K extends Comparable<K>> implements OrderedTree<K> {
    /**
     * Sentinel node for the BST.
     * Marks the boundary of the tree.
     * Sentinel's left child is the actual root.
     */
    private final Node<K> sentinel;

    /**
     * Nil node for the BST.
     * Marks the bottom boundary of the tree.
     * If a node is a leaf, then all its children should be NIL.
     */
    private final Node<K> NIL;

    /**
     * Number of actual nodes in the BST.
     */
    private int size;

    /**
     * Whether the tree has been modified since the last operation.
     */
    private boolean modified;

    /**
     * Constructs a new empty BST.
     */
    public BST() {
        size = 0;
        modified = false;
        sentinel = new Node<>(null, null, null);
        sentinel.left = sentinel;
        sentinel.right = sentinel;
        NIL = sentinel;
    }

    /**
     * Inserts the specified key into this ordered tree.
     *
     * @param key the key to insert
     * @return the reference to the key inserted, or null if the key is already inserted
     * @throws IllegalArgumentException if the key is null
     */
    @Override
    public K insert(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        modified = false;
        setRoot(add(key, root()));
        return modified ? key : null;
    }

    /**
     * Deletes the specified key from this ordered tree.
     *
     * @param key the key to delete
     * @return the reference to the key deleted, or null if the key is not found
     * @throws IllegalArgumentException if the key is null
     */
    @Override
    public K delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        modified = false;
        setRoot(remove(key, root()));
        return modified ? key : null;
    }

    /**
     * Returns whether this ordered tree contains the specified key.
     *
     * @param key the key to check for
     * @return true if this ordered tree contains the specified key,
     * false otherwise
     * @throws IllegalArgumentException if the key is null
     */
    @Override
    public boolean contains(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        return !isOff(find(key, root()));
    }

    /**
     * Returns the specified key if it exists in this ordered tree,
     * or null otherwise.
     *
     * @param key the key to search for
     * @return the reference to the key, or null if the key is not found
     */
    @Override
    public K find(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        // find can directly point to the stored data,
        // instead of the outside storing wrapper
        Node<K> found = find(key, root());
        return !isOff(found) ? found.key : null;
    }

    /**
     * Returns the number of keys in this ordered tree.
     *
     * @return the number of keys in this ordered tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns whether this ordered tree is empty.
     *
     * @return true if this ordered tree is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all keys from this ordered tree.
     */
    @Override
    public void clear() {
        if (isEmpty()) {
            return;
        }
        setRoot(NIL);
        size = 0;
    }

    /**
     * Returns a default iterator over elements of type {@code K}.
     *
     * @return a default iterator
     */
    @Override
    @SuppressWarnings("NullableProblems")
    public Iterator<K> iterator() {
        return inorderIterator();
    }

    /**
     * Returns an iterator over the keys in this ordered tree in inorder.
     * This implementation uses a manual stack to simulate recursion.
     *
     * @return an iterator over the keys in this ordered tree in inorder
     */
    @Override
    public Iterator<K> inorderIterator() {
        return new Iterator<>() {
            private final Stack61B<Node<K>> stack = new DequeStack<>();

            // Initializer block: find the absolute minimum to start
            {
                pushAllLeft(root());
            }

            /**
             * Dives into the left branch of a given subtree, pushing all
             * nodes onto the stack to ensure the smallest is on top.
             *
             * @param node the root node of the subtree to dive into
             */
            private void pushAllLeft(Node<K> node) {
                while (!isOff(node)) {
                    stack.push(node);
                    node = node.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                // The smallest element in the current 'To-Do' list
                Node<K> node = stack.pop();
                K result = node.key;

                // Move to the right child and dive left again to find
                // the next smallest successor.
                pushAllLeft(node.right);

                return result;
            }
        };
    }

    /**
     * Adds the specified key into the BST.
     *
     * @param key the key to add
     * @param current record the current node in the BST
     * @return the root node of the BST after the addition
     */
    private Node<K> add(K key, Node<K> current) {
        // The Edge Case
        if (isOff(current)) {
            size++;
            modified = true;
            return new Node<>(key, NIL, NIL);
        }

        // The Recursive Case
        int cmp = key.compareTo(current.key);
        // HookDown
        if (cmp < 0) {          // Key may be in the left
            // HookDown to left
            current.left = add(key, current.left);
        } else if (cmp > 0) {   // Key may be in the right
            // HookDown to right
            current.right = add(key, current.right);
        }                       // Key found, do nothing
        // HookUp
        return current;
    }

    /**
     * Removes the specified key from the BST.
     *
     * @param key the key to remove
     * @param current record the current node in the BST
     * @return the root node of the BST after the removal
     */
    @SuppressWarnings("RedundantLabeledSwitchRuleCodeBlock")
    private Node<K> remove(K key, Node<K> current) {
        // The Edge Case, key not found
        if (isOff(current)) {
            return NIL;
        }

        // The Recursive Case
        int cmp = key.compareTo(current.key);
        // HookDown
        if (cmp < 0) {          // Key may be in the left
            // HookDown to left
            current.left = remove(key, current.left);
        } else if (cmp > 0) {   // Key may be in the right
            // HookDown to right
            current.right = remove(key, current.right);
        } else {                // Key found
            // remove it by update current node
            modified = true;
            // which later will hook up
            switch (childNumOf(current)) {
                case 0 -> {
                    size--;
                    current = NIL;
                }
                case 1 -> {
                    size--;
                    current = !isOff(current.left) ? current.left : current.right;
                }
                case 2 -> {
                    // random select predecessor or successor to hibbard deletion
                    // will make the tree balanced mathematically
                    // remember only decrease size when actually node deletion happens
                    if (Math.random() < 0.5) {
                        Node<K> predecessor = predecessorOf(current);
                        current.key = predecessor.key;
                        current.left = remove(predecessor.key, current.left);
                    }  else {
                        Node<K> successor = successorOf(current);
                        current.key = successor.key;
                        current.right = remove(successor.key, current.right);
                    }
                }
                default -> {
                    throw new IllegalStateException("Unexpected child num: " + childNumOf(current));
                }
            }
        }
        // HookUp
        return current;
    }

    /**
     * Finds the specified key in the BST.
     *
     * @param key the key to find
     * @param current record the current node in the BST
     * @return the node containing the key if found, or NIL otherwise
     */
    private Node<K> find(K key, Node<K> current) {
        // The Edge Case, key not found
        if (isOff(current)) {
            return NIL;
        }

        // The Recursive Case
        int cmp = key.compareTo(current.key);
        if (cmp < 0) {          // Key may be in the left
            // HookDown to left
            // HookUp
            return find(key, current.left);
        } else if (cmp > 0) {  // Key may be in the right
            // HookDown to right
            // HookUp
            return find(key, current.right);
        } else {              // Key found, just return the found node
            // HookUp
            return current;
        }
    }

    /**
     * Returns the root node of this ordered tree.
     *
     * @return the root node of this ordered tree
     */
    private Node<K> root() {
        return sentinel.left;
    }

    /**
     * Sets the root node of this ordered tree.
     *
     * @param node the new root node of this ordered tree
     */
    private void setRoot(Node<K> node) {
        sentinel.left = node;
    }

    /**
     * Returns whether the specified node is the root node of this ordered tree.
     *
     * @param node the node to check
     * @return true if the specified node is the root node of this ordered tree,
     * false otherwise
     */
    @SuppressWarnings("unused")
    private boolean isRoot(Node<K> node) {
        return node == root();
    }

    /**
     * Returns whether the specified node is a leaf node of this ordered tree.
     *
     * @param node the node to check
     * @return true if the specified node is a leaf node of this ordered tree,
     * false otherwise
     */
    @SuppressWarnings("unused")
    private boolean isLeaf(Node<K> node) {
        return node.left == NIL && node.right == NIL;
    }

    /**
     * Returns whether the specified node is a NIL node of this ordered tree.
     *
     * @param node the node to check
     * @return true if the specified node is a NIL node of this ordered tree,
     * false otherwise
     */
    private boolean isOff(Node<K> node) {
        return node == NIL;
    }

    /**
     * Returns the number of direct children of the specified node.
     *
     * @param node the node to check
     * @return the number of direct children of the specified node
     */
    private int childNumOf(Node<K> node) {
        int cnt = 0;
        if (!isOff(node.left)) {
            cnt++;
        }
        if (!isOff(node.right)) {
            cnt++;
        }
        return cnt;
    }

    /**
     * Returns the successor node of the specified node.
     *
     * @param node the node to find the successor of
     * @return the successor node of the specified node, or NIL if the node has no successor
     */
    private Node<K> successorOf(Node<K> node) {
        if (isOff(node.right)) {
            throw new NoSuchElementException("current node has no successor");
        }

        return minOf(node.right);
    }

    /**
     * Returns the predecessor node of the specified node.
     *
     * @param current the node to find the predecessor of
     * @return the predecessor node of the specified node, or NIL if the node has no predecessor
     */
    private Node<K> predecessorOf(Node<K> current) {
        if (isOff(current.left)) {
            throw new NoSuchElementException("current node has no predecessor");
        }

        return maxOf(current.left);
    }

    /**
     * Returns the minimum node in the specified node.
     *
     * @param current the node to find the minimum of
     * @return the minimum node in the specified node
     */
    private Node<K> minOf(Node<K> current) {
        while (!isOff(current.left)) {
            current = current.left;
        }

        return current;
    }

    /**
     * Returns the maximum node in the specified node.
     *
     * @param current the node to find the maximum of
     * @return the maximum node in the specified node
     */
    private Node<K> maxOf(Node<K> current) {
        while (!isOff(current.right)) {
            current = current.right;
        }

        return current;
    }

    /**
     * Node class for the BST.
     *
     * @param <K> the type of keys stored in the node, must be Comparable
     */
    private static class Node<K extends Comparable<K>> {
        K key;         // Key stored in the node
        Node<K> left;   // Left child node
        Node<K> right;  // Right child node

        /**
         * Constructor for the Node class.
         *
         * @param key  the key to store in the node
         * @param left  the left child node
         * @param right the right child node
         */
        Node(K key, Node<K> left, Node<K> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }
}

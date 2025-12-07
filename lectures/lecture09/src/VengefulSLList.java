public class VengefulSLList<T> extends SLList<T> {
    SLList<T> removedItems;

    public VengefulSLList() {
        removedItems = new SLList<>();
    }

    /**
     * Removes and returns the last item of the list.
     * Record the removed items with a list.
     *
     * @return the removed item
     */
    @Override
    public T removeLast() {
        T removed = super.removeLast();
        removedItems.addLast(removed);
        return removed;
    }

    public void printLostItems() {
        removedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);
        vs1.removeLast();
        vs1.removeLast();
        System.out.println("Removed items:");
        vs1.printLostItems();
    }
}

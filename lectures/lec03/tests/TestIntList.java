/**
 * Test class to test the IntList class.
 */
public class TestIntList {
    public static void main(String[] args) {
        // create a list: 1->2->3->null
        IntList L = new IntList(1, new IntList(2, new IntList(3, null)));

        // test size methods
        System.out.println("Size: " + L.size()); // 3
        System.out.println("Recursive size: " + L.recursiveSize());
        System.out.println("Iterative size: " + L.iterativeSize());

        // test get methods
        System.out.println("Get(1): " + L.get(1)); // 2
        System.out.println("Recursive get(1): " + L.recursiveGet(1));
        System.out.println("Iterative get(1): " + L.iterativeGet(1));

        // test increment methods
        IntList L0 = IntList.increment(L, 1);
        System.out.println("After increment (1): " + L0);
        IntList L1 = IntList.creativeIncrement(L, 1);
        System.out.println("After creative increment (1): " + L1);
        System.out.println("Original list: " + L);
        IntList L2 = IntList.destructiveIncrement(L, 10);
        System.out.println("After destructive increment (10): " + L2);
        System.out.println("Original list: " + L);
        IntList.destructiveIncrement(L, 20);
        System.out.println("After destructive increment (20): " + L2);
        System.out.println("Original list: " + L);
    }
}

/**
 * Test class to test the SLList class.
 */
public class TestSLList {
    public static void main(String[] args) {
        SLList<Integer> list1 = new SLList<>();
        System.out.println("list1.isEmpty() = " + list1.isEmpty());
        list1.addFirst(10);
        System.out.println("List1 after addFirst(10): " + list1);
        list1.addFirst(20);
        System.out.println("List1 after addFirst(20): " + list1);
        System.out.println("list1.getFirst() = " + list1.getFirst());
        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.isEmpty() = " + list1.isEmpty());

        SLList<Integer> list2 = new SLList<>();
        list2.addLast(30);
        System.out.println("List2 after addLast(30): " + list2);
        list2.addLast(40);
        System.out.println("List2 after addLast(40): " + list2);
        System.out.println("list2.getLast() = " + list2.getLast());
        System.out.println("list2.size() = " + list2.size());
    }
}

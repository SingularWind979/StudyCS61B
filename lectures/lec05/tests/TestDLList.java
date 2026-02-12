/**
 * Test class to test the SLList class.
 */
public class TestDLList {
    public static void main(String[] args) {
        DLList<Integer> list1 = new DLList<>();
        System.out.println("list1.isEmpty() = " + list1.isEmpty());
        list1.addFirst(10);
        System.out.println("List1 after addFirst(10): " + list1);
        list1.addFirst(20);
        System.out.println("List1 after addFirst(20): " + list1);
        System.out.println("list1.getFirst() = " + list1.getFirst());
        System.out.println("list1.size() = " + list1.size());
        System.out.println("list1.isEmpty() = " + list1.isEmpty());
        Integer removedFirst1 = list1.removeFirst();
        System.out.println("List1 after removeFirst(): " + list1);
        System.out.println("Removed first element: " + removedFirst1);

        DLList<Integer> list2 = new DLList<>();
        list2.addLast(30);
        System.out.println("List2 after addLast(30): " + list2);
        list2.addLast(40);
        System.out.println("List2 after addLast(40): " + list2);
        System.out.println("list2.getLast() = " + list2.getLast());
        System.out.println("list2.size() = " + list2.size());
        Integer removedLast2 = list2.removeLast();
        System.out.println("List2 after removeLast(): " + list2);
        System.out.println("Removed last element: " + removedLast2);
    }
}

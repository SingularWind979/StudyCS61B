public class RotatingSLList<T> extends SLList<T> {
    public void rotateRight() {
        T last = removeLast();
        addFirst(last);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rs1 = new RotatingSLList<>();
        rs1.addLast(5);
        rs1.addLast(9);
        rs1.addLast(15);
        rs1.addLast(22);
        System.out.println("Before RotatingRight:");
        rs1.print();
        rs1.rotateRight();
        System.out.println("After RotatingRight:");
        rs1.print();
    }
}

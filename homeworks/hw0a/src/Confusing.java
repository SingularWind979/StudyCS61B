/**
 * Confusing Question:
 * What is the output from the following Java program?
 *
 * @author SingularWind
 */
public class Confusing {
    public static void main(String[] args) {
        method1();  // 1
        method3();  // 1, 2, 3, 1
        method2();  // 1, 2
        method3();  // 1, 2, 3, 1
    }

    private static void method1() {
        System.out.println("I am method 1.");
    }

    private static void method2() {
        method1();
        System.out.println("I am method 2.");
    }

    private static void method3() {
        method2();
        System.out.println("I am method 3.");
        method1();
    }
}

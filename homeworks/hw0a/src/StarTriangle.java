import java.util.Scanner;

/**
 * Prints a star triangle.
 *
 * @author SingularWind
 */
public class StarTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows in the triangle:");
        int n = sc.nextInt();
        starTriangle(n);
    }

    /**
     * Prints a star triangle.
     *
     * @param n the number of rows in the triangle
     */
    public static void starTriangle(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("*".repeat(i + 1));
        }
    }
}

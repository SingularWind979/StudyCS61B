import java.util.Scanner;

/**
 * A class that can find the larger number between two integers.
 *
 * @author SingularWind
 */
public class Larger {
    private static int input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        return sc.nextInt();
    }
    public static int larger(int x, int y) {
        return Math.max(x, y);
    }

    public static void main(String[] args) {
        int x = input();
        int y = input();

        System.out.println("The larger number is: " + larger(x, y));
    }
}

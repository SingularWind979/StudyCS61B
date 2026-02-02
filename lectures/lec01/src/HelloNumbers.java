import java.util.Scanner;

/**
 * A class that prints numbers.
 *
 * @author SingularWind
 */
public class HelloNumbers {
    private static int input() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        return input.nextInt();
    }
    
    public static void main(String[] args) {
        int lowerBound = 0;
        int upperBound = input();

        int x = lowerBound;
        while (x <= upperBound) {
            System.out.print(x + " ");
            x++;
        }
    }
}

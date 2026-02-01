import java.util.Scanner;

/**
 * Find the quadrant of a point in the Cartesian coordinate system.
 *
 * @author SoingularWind
 **/
public class Quadrant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the x and y coordinates: ");
        System.out.print("x:");
        int x = input.nextInt();
        System.out.print("y:");
        int y = input.nextInt();
        System.out.println("The point (" + x + ", " + y + ") is in quadrant " + quadrant(x, y));
    }

    /**
     * Find the quadrant of a point in the Cartesian coordinate system.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @return the quadrant of the point
     */
    public static int quadrant(int x, int y) {
        if (y == 0 || x == 0) {
            return 0;               // axis
        } else if (y > 0) {
            if (x > 0) {
                return 1;   // quadrant 1
            } else {
                return 2;   // quadrant 2
            }
        } else {
            if (x < 0) {
                return 3;   // quadrant 3
            } else {
                return 4;   // quadrant 4
            }
        }
    }
}

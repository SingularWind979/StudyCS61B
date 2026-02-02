/**
 * IfElseMystery Question:
 * For each call below, What is the output?
 *
 * @author SingularWind
 */
public class IfElseMystery {
    public static void main(String[] args) {
        ifElseMystery(3, 20);   // 13 21
        ifElseMystery(4, 5);    // 5 6
        ifElseMystery(5, 5);    // 6 5
        ifElseMystery(6, 10);   // 7 11
    }

    private static void ifElseMystery(int x, int y) {
        int z = 4;

        if (z <= x) {
            z = x + 1;
        } else {
            z = z + 9;
        }

        if (z <= y) {
            y++;
        }

        System.out.println(z + " " + y);
    }
}

import java.util.Scanner;

/**
 * Stutter the characters of a string.
 *
 * @author SingularWind
 */
public class Stutter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a string:");
        String input = sc.nextLine();
        System.out.println(stutter(input));
    }

    /**
     * Stutter the characters of a string.
     *
     * @param str the string to stutter
     * @return the stuttered string
     */
    public static String stutter(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch).append(ch);
        }
        return sb.toString();
    }
}

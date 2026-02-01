import java.util.Scanner;

/**
 * Print the characters of a string along with their indices.
 *
 * @author SoingularWind
 **/
public class PrintIndexed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input a string:");
        String input = sc.nextLine();
        printIndexedStr(input);
    }

    /**
     * Print the characters of a string along with their indices.
     *
     * @param str the string to print
     */
    public static void printIndexedStr(String str) {
        StringBuilder cha = new StringBuilder();
        StringBuilder idx = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                // add the character
                cha.append(ch).append("\t");
                // add the index
                idx.append(i).append("\t");
            }
        }

        System.out.println(cha);
        System.out.println(idx);
    }
}

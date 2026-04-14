import java.util.Random;
import java.util.regex.Pattern;

/**
 * Utility function for Strings.
 *
 * @author Josh Hug
 */
public class StringUtils {
    /** To get the style checker to be quiet. */
    private static final int ALPHABET_SIZE = 26;

    /** Random number generator for this class. */
    private static Random r = new Random();

    /**
     * Sets random seed to {@code l}
     * so that results of randomString are predictable.
     *
     * @param l the random seed to set
     */
    public static void setSeed(long l) {
        r = new Random(l);
    }

    /**
     * Returns the next random string of length {@code length}.
     *
     * @param length the length of the random string
     * @return the random lower case string of length {@code length}
     */
    public static String randomString(int length) {
        char[] someChars = new char[length];
        for (int i = 0; i < length; i++) {
            someChars[i] = (char) (r.nextInt(ALPHABET_SIZE) + 'a');
        }
        return new String(someChars);
    }

    /**
     * Returns true if string {@code str} consists of lower case letters only.
     * No spaces, numbers, upper-case letters, or any other characters are allowed.
     *
     * @param str the string to check
     * @return true if string {@code str} consists of lower case letters only
     */
    public static boolean isLowerCase(String str) {
        return Pattern.matches("[a-z]*", str);
    }

    /**
     * Returns the string that comes right after {@code str} in alphabetical order.
     * For example, if str is 'potato', this method will return 'potatp'.
     *
     * @param str the string to increment
     * @return the next string in alphabetical order
     */
    public static String nextString(String str) {
        // Handle all zs as a special case,
        // to keep helper method simple.
        if (isAllZs(str)) {
            return allAs(str.length() + 1);
        }
        char[] charVersion = str.toCharArray();
        incrementCharArray(charVersion, charVersion.length - 1);
        return new String(charVersion);
    }

    /**
     * Increments the {@code pos}th position of {@code charArray} by one.
     * If the character at {@code pos} is already 'z', we wrap around to 'a'
     * and increment position {@code pos - 1}.
     * Will fail for a character array containing only Zs.
     *
     * @param charArray the character array to increment
     * @param pos the position to increment
     */
    private static void incrementCharArray(char[] charArray, int pos) {
        if (charArray[pos] != 'z') {
            charArray[pos] += 1;
        } else {
            charArray[pos] = 'a';
            incrementCharArray(charArray, pos - 1);
        }
    }

    /**
     * Returns a string of all 'a' of length {@code len}.
     *
     * @param len the length of the string
     * @return the string of all 'a' of length {@code len}
     */
    private static String allAs(int len) {
        return "a".repeat(len);
    }

    /**
     * Checks whether {@code str} is all 'z'.
     * False for empty strings.
     *
     * @param str the string to check
     * @return true if {@code str} is all 'z', false otherwise
     */
    public static boolean isAllZs(String str) {
        return Pattern.matches("z+", str);
    }
}

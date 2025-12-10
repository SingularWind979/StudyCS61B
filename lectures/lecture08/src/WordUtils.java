/**
 * Utility class includes functions we can run on lists of words
 *
 * @author Singularwind
 */
public final class WordUtils {
    private WordUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated.");
    }

    /**
     * Calculates the longest string in a list.
     *
     * @param list a list of strings
     * @return the longest string in the list
     * same length return the first occurred string
     */
    public static String longest(MyList<String> list) {
        String longest = "";
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }
}

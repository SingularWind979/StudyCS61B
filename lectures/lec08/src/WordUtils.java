/**
 * A utility class for working with words.
 *
 * @author SingularWind
 */
public class WordUtils {
    private WordUtils() { }

    /**
     * Returns the longest word in the given array of words.
     *
     * @param words the array of words to search
     * @return the longest word in the array
     */
    public static String longest(MyList<String> words) {
        String longest = "";
        for (int i = 0; i < words.size(); i++) {
            String current = words.get(i);
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        return longest;
    }
}

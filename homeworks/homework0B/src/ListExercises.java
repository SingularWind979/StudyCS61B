import java.util.ArrayList;
import java.util.List;

public class ListExercises {
    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        for (int num : L) {
            sum += num;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evens = new ArrayList<>();
        for (int num : L) {
            if (num % 2 == 0) {
                evens.add(num);
            }
        }
        return evens;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List <Integer> common = new ArrayList<>();
        for (Integer num : L1) {
            if(L2.contains(num)) {
                common.add(num);
            }
        }
        return common;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (ch == c) {
                    count++;
                }
            }
        }
        return count;
    }
}

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Scanner;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Performs a timing test on three different set implementations.
 *
 * @author Josh Hug
 * @author Brendan Hu
 */
@SuppressWarnings("CallToPrintStackTrace")
public class InsertRandomSpeedTest {
    /**
     * Requests user input and performs tests
     * of three different set implementations.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println(
                """
                This program inserts random Strings of length L \
                into different types of maps as <String, Integer> pairs.
                """
        );
        System.out.print("Please enter desired length of each string: ");
        int L = waitForPositiveInt(input);

        String repeat;
        do {
            System.out.print("\nEnter # strings to insert into the maps: ");
            int N = waitForPositiveInt(input);
            timeRandomMap61B(new ULLMap<>(), N, L);
            timeRandomMap61B(new BSTMap<>(), N, L);
            timeRandomTreeMap(new TreeMap<>(), N, L);
            timeRandomHashMap(new HashMap<>(), N, L);

            System.out.print("Would you like to try more timed-tests? (y/n)");
            repeat = input.nextLine();
        } while (!repeat.equalsIgnoreCase("n") && !repeat.equalsIgnoreCase("no"));
        input.close();
    }

    /**
     * Returns time needed to put N random strings of length L
     * into the given Map61B 61bMap.
     *
     * @param map61B the Map61B to insert into
     * @param N the number of random strings to insert
     * @param L the length of each random string
     * @return the time needed to insert N random strings of length L into map61B
     */
    public static double insertRandom(Map61B<String, Integer> map61B, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s;
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            map61B.put(s, i);
        }
        return sw.elapsedTime();
    }

    /** Returns time needed to put N random strings of length L
     * into the given TreeMap.
     *
     * @param treeMap the TreeMap to insert into
     * @param N the number of random strings to insert
     * @param L the length of each random string
     * @return the time needed to insert N random strings of length L into treeMap
     */
    public static double insertRandom(TreeMap<String, Integer> treeMap, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s;
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            treeMap.put(s, i);
        }
        return sw.elapsedTime();
    }

    /** Returns time needed to put N random strings of length L
     * into the given HashMap.
     *
     * @param hashMap the HashMap to insert into
     * @param N the number of random strings to insert
     * @param L the length of each random string
     * @return the time needed to insert N random strings of length L into hashMap
     */
    public static double insertRandom(HashMap<String, Integer> hashMap, int N, int L) {
        Stopwatch sw = new Stopwatch();
        String s;
        for (int i = 0; i < N; i++) {
            s = StringUtils.randomString(L);
            hashMap.put(s, i);
        }
        return sw.elapsedTime();
    }

    /**
     * Attempts to insert N random strings of length L into map.
     * Prints time of the N insert calls,
     * otherwise prints a nice message about the error.
     *
     * @param map the Map61B to insert into
     * @param N the number of random strings to insert
     * @param L the length of each random string
     */
    public static void timeRandomMap61B(Map61B<String, Integer> map, int N, int L) {
        try {
            double mapTime = insertRandom(map, N, L);
            System.out.printf(map.getClass() + ": %.2f sec\n", mapTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attempts to insert N random strings of length L into treeMap.
     * Prints time of the N insert calls,
     * otherwise prints a nice message about the error.
     *
     * @param treeMap the TreeMap to insert into
     * @param N the number of random strings to insert
     * @param L the length of each random string
     */
    public static void timeRandomTreeMap(TreeMap<String, Integer> treeMap, int N, int L) {
        try {
            double javaTime = insertRandom(treeMap, N, L);
            System.out.printf("Java's Built-in TreeMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attempts to insert N random strings of length L into hashMap.
     * Prints time of the N insert calls,
     * otherwise prints a nice message about the error.
     *
     * @param hashMap the HashMap to insert into
     * @param N the number of random strings to insert
     * @param L the length of each random string
     */
    public static void timeRandomHashMap(HashMap<String, Integer> hashMap, int N, int L) {
        try {
            double javaTime = insertRandom(hashMap, N, L);
            System.out.printf("Java's Built-in HashMap: %.2f sec\n", javaTime);
        } catch (StackOverflowError e) {
            printInfoOnStackOverflow(N, L);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the user on other side of Scanner
     * input to enter a positive int,
     * and outputs that int.
     *
     * @param input the Scanner to read from
     * @return the positive int entered by the user
     */
    public static int waitForPositiveInt(Scanner input) {
        int ret;
        do {
            while (!input.hasNextInt()) {
                errorBadIntegerInput();
                input.next();
            }
            ret = input.nextInt();
            input.nextLine(); //consume not taken by nextInt()
        } while (ret <= 0);
        return ret;
    }

    /* ------------------------------- Private methods ------------------------------- */

    /**
     * To be called after catching a StackOverflowError.
     * Prints the error with corresponding N and L
     *
     * @param N the number of random strings to insert
     * @param L the length of each random string
     */
    private static void printInfoOnStackOverflow(int N, int L) {
        System.out.printf("--Stack Overflow -- "
                + "couldn't add %d strings of length %d.%n", N, L);
    }

    /**
     * Prints a nice message for the user on bad input.
     */
    private static void errorBadIntegerInput() {
        System.out.print("Please enter a positive integer: ");
    }
}

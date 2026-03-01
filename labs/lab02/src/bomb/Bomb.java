package bomb;

import common.IntList1;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Bomb {
    // DO NOT MODIFY THIS FILE

    public String shufflePassword(String s) {
        String code = "" + s.hashCode();
        StdRandom.setSeed(1337);
        char[] chars = code.toCharArray();
        StdRandom.shuffle(chars);
        return String.valueOf(chars);
    }

    public IntList1 shufflePasswordIntList(String s) {
        String code = "" + s.hashCode();
        StdRandom.setSeed(61833);
        char[] chars = code.toCharArray();
        StdRandom.shuffle(chars);

        IntList1 curr = null;
        for (int i = chars.length - 1; i >= 0; i--) {
            curr = new IntList1(Integer.parseInt(String.valueOf(chars[i])), curr);
        }

        return curr;
    }

    public void phase0(String password) {
        String correctPassword = shufflePassword("hello");
        if (!password.equals(correctPassword)) {
            System.out.println("Phase 0 went BOOM!");
            return;
        }
        System.err.println("You passed phase 0 with the password \"" + password + "\"");
    }

    public void phase1(IntList1 password) {
        IntList1 correctIntListPassword = shufflePasswordIntList("bye");
        if (!correctIntListPassword.equals(password)) {
            System.out.println("Phase 1 went BOOM!");
            return;
        }
        System.err.print("You passed phase 1 with the password \"");
        System.err.print(password.print());
        System.err.println("\"");
    }

    public void phase2(String password) {
        Random r = new Random(1337);
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 100000) {
            numbers.add(r.nextInt());
        }

        boolean correct = false;
        int i = 0;
        for (int number : numbers) {
            if (i == 1337 && Integer.parseInt(password) == number) {
                correct = true;
            }
            i++;
        }
        if (!correct) {
            System.out.println("Phase 2 went BOOM!");
            return;
        }
        System.err.println("You passed phase 2 with the password \"" + password + "\"");
    }

}

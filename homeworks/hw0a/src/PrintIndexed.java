public class PrintIndexed {
    public static void main(String[] args) {
        printIndexed("Hello");
    }

    public static void printIndexed(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // print the character
            sb.append(str.charAt(i)).append(" ");
            // print the index
            sb.append((str.length() - i - 1)).append("\n");
        }
        System.out.println(sb);
    }
}

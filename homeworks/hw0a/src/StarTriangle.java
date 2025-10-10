public class StarTriangle {
    public static void main(String[] args) {
        starTriangle();
    }

    public static void starTriangle() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            sb.append("*".repeat(i + 1));
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}

public class Quadrant {
    public static void main(String[] args) {
        System.out.println(quadrant(1, 1));
    }
    public static int quadrant(int x, int y) {
        if (y == 0 || x == 0) {
            return 0;       // 坐标轴
        } else if (y > 0) {
            if (x > 0)  return 1;   // 第一象限
            else        return 2;   // 第二象限
        } else {
            if (x < 0)  return 3;   // 第三象限
            else        return 4;   // 第四象限
        }
    }
}

package bomb;

import common.IntList1;

public class BombMain {
    public static void answers(String[] args) {
        int phase = 2;
        if (args.length > 0) {
            phase = Integer.parseInt(args[0]);
        }

        Bomb b = new Bomb();
        if (phase >= 0) {
            b.phase0("39291226");
        }
        if (phase >= 1) {
            b.phase1(IntList1.of(0, 9, 3, 0, 8));
        }
        if (phase >= 2) {
            b.phase2("-81201430");
        }
    }
}

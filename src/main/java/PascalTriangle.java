import java.util.Arrays;
import java.util.BitSet;

/**
 * @author emorenkov
 */
public class PascalTriangle {

    public static void main(String[] args) {
//        System.out.println(makeChange(100, 25));
        String[] array = new String[]{"ASDASD"};
        Arrays.sort(array, String::compareTo);
        System.out.println(-7 % 5);
//        System.out.println(countPathNumber(1));
//        System.out.println(countPathNumber(2));
//        System.out.println(countPathNumber(3));
//        System.out.println(countPathNumber(4));
    }

    public static int makeChange(int n, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, next_denom);
        }
        return ways;
    }


    static long countPathNumber(int n) {
        StringBuilder sb = new StringBuilder();
        Chess[][] array = new Chess[8][8];
//        BitSet bs = new BitSet("10101");
        Integer t = 5;
        long l = t.longValue();
//        sb.p


        long pathNumber = 1;
        for (int i = n + 1; i <= 2 * n; i++) {
            pathNumber *= i;
        }
        for (int i = 2; i <= n; i++) {
            pathNumber /= i;
        }
        return pathNumber;
    }

    enum Chess {
        EMPTY,
        QUEEN,
        FORBIDDEN;
    }
}

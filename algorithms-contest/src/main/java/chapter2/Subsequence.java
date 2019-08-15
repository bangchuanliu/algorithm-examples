package chapter2;

import java.math.BigDecimal;

public class Subsequence {

    public static BigDecimal sum(int n, int m) {
        double sum = 0;
        for (int i = n; i <= m; i++) {
            sum += 1.0 / i * 1.0 / i;
        }

        return BigDecimal.valueOf(sum).setScale(5, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        System.out.println(sum(2, 4));
        System.out.println(sum(65536, 655360));

        System.out.println();
    }
}

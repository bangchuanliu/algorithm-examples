package basicprogrammingmodel;

public class Binomial {

    public static double binomialRecursive(int n, int k, double p) {
        if (n == 0 && k == 0) {
            return 1;
        }
        if (n < 0 || k < 0) {
            return 0;
        }

        return (1.0 - p) * binomialRecursive(n - 1, k, p) + p * binomialRecursive(n - 1, k - 1, p);
    }


    public static double binomialDp(int n, int k, double p) {
        double[][] a = new double[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            a[i][0] = Math.pow((1.0 - p), i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j <= i) {
                    a[i][j] = (1.0 - p) * a[i - 1][j] + p * a[i - 1][j - 1];
                }
            }
        }
        return a[n][k];
    }

    public static void main(String[] args) {
        System.out.println(binomialRecursive(100, 50, 0.5));
        System.out.println(binomialDp(100, 50, 0.5));
    }
}

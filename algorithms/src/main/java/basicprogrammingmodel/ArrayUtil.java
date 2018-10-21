package basicprogrammingmodel;

import java.util.Arrays;

public class ArrayUtil {

    public int max(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public double avg(int[] a) {
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum / a.length;
    }

    public int[] copy(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }

        return b;
    }

    public int[] reverse(int[] a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            int temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = temp;
        }
        return a;
    }

    public double[][] matrixMultiply(int[][] a, int[][] b) {
        int N = b.length;
        double[][] c = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    c[i][j] = a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    public static <Item> void swap(Item[] a, int i, int j) {
        Item temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        ArrayUtil arrayUtil = new ArrayUtil();
        int[] a = {1, 2, 3, 4, 5};
        int[][] c = {{1, 2}, {1, 2}};
        int[][] d = {{1, 2}, {1, 2}};
        System.out.println(arrayUtil.max(a));
        System.out.println(arrayUtil.avg(a));
        System.out.println(Arrays.toString(arrayUtil.copy(a)));
        System.out.println(Arrays.toString(arrayUtil.reverse(a)));
        System.out.println(Arrays.toString(arrayUtil.matrixMultiply(c, d)));
    }
}

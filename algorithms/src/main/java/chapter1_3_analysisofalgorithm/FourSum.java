package chapter1_3_analysisofalgorithm;

import chapter1_1_basicprogrammingmodel.BinarySearchUtil;
import chapter1_1_basicprogrammingmodel.RandomUtil;
import chapter1_1_basicprogrammingmodel.StopWatch;

import java.util.Arrays;

public class FourSum {

    public static void count(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    for (int l = k + 1; l < a.length; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 0) {
//                            System.out.print("i, j, k , l : " + i + j + k + l + "\n");
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static void countFast(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    int l = BinarySearchUtil.search(a, -a[i] - a[j] - a[k]);
                    if (l > k) {
//                        System.out.print("i, j, k , l : " + i + j + k + l + "\n");
                        count++;
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static void countWithTwoPointer(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int l = j + 1;
                int h = a.length - 1;
                while (l < h) {
                    if (a[l] + a[h] == -a[i] - a[j]) {
//                        System.out.print("i, j, l , h : " + i + j + l + h + "\n");
                        count++;
                        l++;
                        h--;
                        int m = l;
                        int n = h;
                        while (h > m - 1 && a[h] == a[h+1]) {
//                            System.out.print("i, j, k , l : " + i + j + m + h + "\n");
                            count++;
                            h--;
                        }
                        while (l < n + 1 && a[l] == a[l - 1]) {
//                            System.out.print("i, j, k , l : " + i + j + l + n + "\n");
                            count++;
                            l++;
                        }
                        l = m;
                        h = n;
                    } else if (a[l] + a[h] > -a[i] - a[j]) {
                        h--;
                    } else {
                        l++;
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        int[] a = new int[100];
        int[] b = new int[10000];

        for (int i = 0; i < a.length; i++) {
            int num = RandomUtil.uniform(-100, 100);
            a[i] = num;
        }
        for (int i = 0; i < b.length; i++) {
            int num = RandomUtil.uniform(-10000, 10000);
            b[i] = num;
        }
//        int[] c = {-7, -6, -5, -4, 2, 6, 6, 7, 7, 7};
        StopWatch stopWatch = new StopWatch();
        count(a);
//        System.out.println(stopWatch.elapseTime());
        System.out.println(Arrays.toString(a));
        StopWatch stopWatch3 = new StopWatch();
        countWithTwoPointer(a);
//        System.out.println(stopWatch3.elapseTime());
    }
}

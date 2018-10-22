package AnalysisOfAlgorithm;

import basicprogrammingmodel.BinarySearchUtil;
import basicprogrammingmodel.RandomUtil;
import basicprogrammingmodel.StopWatch;

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
                            int m = a[l];
                            int n = a[h];
                            while (h > l && a[h] == n) {
                                count++;
                                h--;
                            }
                            while (l+1 < h && a[l+1] == m) {
                                count++;
                                l++;
                            }
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
        StopWatch stopWatch = new StopWatch();
        count(a);
        System.out.println(stopWatch.elapseTime());
        System.out.println(Arrays.toString(a));
        StopWatch stopWatch2 = new StopWatch();
        countFast(a);
        System.out.println(stopWatch2.elapseTime());
        StopWatch stopWatch3 = new StopWatch();
        countWithTwoPointer(a);
        System.out.println(stopWatch3.elapseTime());
    }
}

package AnalysisOfAlgorithm;

import basicprogrammingmodel.BinarySearchUtil;
import basicprogrammingmodel.RandomUtil;
import basicprogrammingmodel.StopWatch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * cases:
 * <p>
 * Array may have duplicated elements
 * <p>
 * 1. find one pair
 * 2. find count of all pairs
 * 3. find all unique pairs by value
 * 4. find all unique paris by array index
 */

public class TwoSum {

    /**
     * time complexity: N * N
     */
    public static void count(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
    }

    /**
     * running time : linearithmic, NlogN
     * not accurate given duplicated elements
     */
    public static void countFast(int[] a) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i])) {
                count++;
            } else {
                set.add(-a[i]);
            }
        }
        System.out.println("count = " + count);
    }

    /**
     * running time : linearithmic, NlogN
     * not accurate given duplicated elements
     */
    public static void countFaster(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (BinarySearchUtil.search(a, -a[i]) > i) {
                count++;
            }
        }
        System.out.println("count = " + count);
    }

    /**
     * running time : linearithmic, NlogN
     */
    public static void countWithTwoPointer(int[] a) {
        int count = 0;
        Arrays.sort(a);
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] == 0) {
                count++;
                i++;
                j--;
                while (i < j && a[j] == a[j + 1]) {
                    count++;
                    j--;
                }
                while (i < j && a[i] == a[i - 1]) {
                    count++;
                    i++;
                }
            } else if (a[i] + a[j] > 0) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[10000];

        for (int i = 0; i < a.length; i++) {
            int num = RandomUtil.uniform(-10, 10);
            a[i] = num;
        }
        for (int i = 0; i < b.length; i++) {
            int num = RandomUtil.uniform(-10000, 10000);
            b[i] = num;
        }

        StopWatch stopWatch = new StopWatch();
        count(a);
        System.out.println(stopWatch.elapseTime());
        StopWatch stopWatch2 = new StopWatch();
        countFast(a);
        System.out.println(stopWatch2.elapseTime());
        StopWatch stopWatch3 = new StopWatch();
        countFaster(a);
        System.out.println(stopWatch3.elapseTime());
        StopWatch stopWatch4 = new StopWatch();
        countWithTwoPointer(a);
        System.out.println(stopWatch4.elapseTime());
    }
}

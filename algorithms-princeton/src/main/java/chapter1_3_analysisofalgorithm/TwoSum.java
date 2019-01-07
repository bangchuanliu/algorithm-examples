package chapter1_3_analysisofalgorithm;

import chapter1_1_basicprogrammingmodel.BinarySearchUtil;
import chapter1_1_basicprogrammingmodel.RandomUtil;
import chapter1_1_basicprogrammingmodel.StopWatch;

import java.util.*;

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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                count++;
                int cnt = map.get(a[i]);
                if (cnt > 1) {
                    map.put(a[i], cnt - 1);
                } else {
                    map.remove(a[i]);
                }
            } else {
                if (map.containsKey(-a[i])) {
                    map.put(-a[i],map.get(-a[i]) + 1);
                } else {
                    map.put(-a[i], 1);    
                }
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
                int m = i;
                int n = j;
                while (m-1 < j && a[j] == a[j + 1]) {
                    count++;
                    j--;
                }
                while (i < n + 1 && a[i] == a[i - 1]) {
                    count++;
                    i++;
                }
                i = m;
                j = n;
            } else if (a[i] + a[j] > 0) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        int[] b = new int[10000];

        for (int i = 0; i < a.length; i++) {
            int num = RandomUtil.uniform(-1000, 1000);
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

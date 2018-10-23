package chapter1_3_analysisofalgorithm;

import chapter1_1_basicprogrammingmodel.BinarySearchUtil;
import chapter1_1_basicprogrammingmodel.RandomUtil;
import chapter1_1_basicprogrammingmodel.StopWatch;

import java.util.*;

public class ThreeSum {

    public static void count(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count++;
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static void countFast(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            Set<Integer> set = new HashSet<>();
            int sum = -a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (set.contains(a[j])) {
                    count++;
                } else {
                    set.add(sum - a[j]);
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static void countFaster(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (BinarySearchUtil.search(a, -a[i] - a[j]) > j) {
                    count++;
                }
            }
        }
        System.out.println("count = " + count);
    }

    public static void main(String[] args) {
        int[] a = new int[1000];
        int[] b = new int[10000];

        for (int i = 0; i < a.length; i++) {
            int num = RandomUtil.uniform(-10000, 10000);
            a[i] = num;
        }
        for (int i = 0; i < b.length; i++) {
            int num = RandomUtil.uniform(-10000, 10000);
            b[i] = num;
        }

        StopWatch stopWatch = new StopWatch();
        count(a);
        System.out.println("count : " + stopWatch.elapseTime());
        StopWatch stopWatch2 = new StopWatch();
        countFast(a);
        System.out.println("count fast : " + stopWatch2.elapseTime());
        StopWatch stopWatch3 = new StopWatch();
        countFaster(a);
        System.out.println("count faster : " + stopWatch3.elapseTime());
        
        
        StopWatch stopWatch4 = new StopWatch();
//        count(b);
        System.out.println("count : " + stopWatch4.elapseTime());
        StopWatch stopWatch5 = new StopWatch();
        countFast(b);
        System.out.println("count fast : " + stopWatch5.elapseTime());
        StopWatch stopWatch6 = new StopWatch();
        countFaster(b);
        System.out.println("count faster : " + stopWatch6.elapseTime());
    }
}

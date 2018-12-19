package graph.assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProbeTwoSum {


    public static Integer twoSums(long[] a, int low, int high) {
        long start = System.currentTimeMillis();
        int count = 0;

        for (int k = low; k <= high; k++) {
            int i = 0;
            int j = a.length - 1;
            while (i <= j) {
                long sum = a[i] + a[j];
                if (sum > k) {
                    j--;
                } else if (sum < k) {
                    i++;
                } else {
                    count++;
                    //System.out.println("target : " + sum);
                    break;
                }
            }
        }
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000);
        return count;
    }

    public static Integer twoSumsFaster(long[] a, int low, int high) {
        Set<Long> sets = new HashSet<>();
        long start = System.currentTimeMillis();
        int i = 0;
        int j = a.length - 1;
        while (i < j) {
            if (a[i] + a[j] > high) {
                j--;
                continue;
            } 
            
            if (a[i] + a[j] < low) {
                i++;
                continue;
            } 
            
//            if (a[i] == a[j]) { // distinct pair
//                break;
//            }
            
            int k = i;
            long sum = a[k] + a[j];
            while (sum >= low && sum <= high) {
                sets.add(sum);
                k++;
//                if (a[k] == a[j]) { // distinct
//                    break;
//                }
                sum = a[k] + a[j];
            }
            j--;
        }
        System.out.println("time : " + (System.currentTimeMillis() - start) / 1000);
        return sets.size();
    }


    public static void main(String[] args) throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/algo1-programming_prob-2sum.txt";
        List<String> list = Files.lines(Paths.get(path)).filter(str -> str.length() > 0).distinct().collect(Collectors.toList());
        long[] theArray = new long[list.size()];
        for (int i = 0; i < theArray.length; i++) {
            theArray[i] = Long.parseLong(list.get(i));
        }
        Arrays.sort(theArray);
//        int[] a = {-3,-1,1,2,9,11,7,6,2};
//        System.out.println(twoSums(a, 0, 10));

        System.out.println(twoSumsFaster(theArray, -10000, 10000));
    }
}

package course2.assignment4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProbeTwoSum {

    public static Integer probeTwoSum(long[] a, int low, int high) {
        Arrays.sort(a);
        Set<Long> sets = new HashSet<>();
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
        return sets.size();
    }


    public static void main(String[] args) throws IOException {
        String path = ProbeTwoSum.class.getClassLoader().getResource("course2/assignment4/data/algo1-programming_prob-2sum.txt").getPath();
        long[] nums = Files.lines(Paths.get(path)).mapToLong(line -> Long.parseLong(line)).toArray();
//        int[] a = {-3,-1,1,2,9,11,7,6,2};
        System.out.println(probeTwoSum(nums, -10000, 10000));
    }
}

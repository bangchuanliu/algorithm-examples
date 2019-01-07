package course1.assignment2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerInversion {

    public static long inversionCount = 0;
    public static int[] aux;

    public static long count(int[] nums) {
        inversionCount = 0;
        aux = new int[nums.length];
        count(nums, 0, nums.length - 1);
        return inversionCount;
    }

    public static void count(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        count(nums, low, mid);
        count(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = nums[i];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > high) {
                nums[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                inversionCount += mid - i + 1;
                nums[k] = aux[j++];
            } else {
                nums[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 2407905288
        run();
//        runTest();
    }

    public static void run() throws IOException {
        String path = IntegerInversion.class.getClassLoader().getResource("course1/assignment2/data/IntegerArray.txt").getPath();
        int[] nums = Files.lines(Paths.get(path)).mapToInt(line -> Integer.parseInt(line)).toArray();
        System.out.println(count(nums));
    }

    public static void runTest() throws IOException {
        String test1 = IntegerInversion.class.getClassLoader().getResource("course1/assignment2/testcase/test1.txt").getPath();
        String test2 = IntegerInversion.class.getClassLoader().getResource("course1/assignment2/testcase/test2.txt").getPath();
        String test3 = IntegerInversion.class.getClassLoader().getResource("course1/assignment2/testcase/test3.txt").getPath();
        int[] nums1 = Files.lines(Paths.get(test1)).mapToInt(line -> Integer.parseInt(line)).toArray();
        int[] nums2 = Files.lines(Paths.get(test2)).mapToInt(line -> Integer.parseInt(line)).toArray();
        int[] nums3 = Files.lines(Paths.get(test3)).mapToInt(line -> Integer.parseInt(line)).toArray();
        System.out.println(count(nums1));
        System.out.println(count(nums2));
        System.out.println(count(nums3));
    }
}

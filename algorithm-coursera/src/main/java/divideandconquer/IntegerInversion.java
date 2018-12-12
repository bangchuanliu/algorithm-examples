package divideandconquer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerInversion {


    public static int countBruteForce(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    static long inversionCount = 0;

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

    static int[] aux;

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
        String path = "/Users/b0l00ev/Documents/personal/data/IntegerArray.txt";
        List<String> list = Files.lines(Paths.get(path)).collect(Collectors.toList());
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(list.get(i));
        }
        
        int[] a = {1, 3, 5, 2, 4, 6};
        int[] b = {4, 3, 2, 1};
        int[] c = {1, 2, 3, 4};

        System.out.println(countBruteForce(a));
        System.out.println(countBruteForce(b));
        System.out.println(countBruteForce(c));
//        System.out.println(countBruteForce(nums));
        System.out.println(nums.length);
        System.out.println(count(a));
        System.out.println(count(b));
        System.out.println(count(c));
        System.out.println(count(nums));
    }
}

package course1.assignment3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class QuickSortComparision {

    public static long sort(int[] a) {
        return sort(a, 0, a.length - 1);
    }

    public static long sort(int[] a, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int pivot = partition3(a, low, high);
        long left = sort(a, low, pivot - 1);
        long right = sort(a, pivot + 1, high);
        return left + right + high - low;
    }

    /**
     * choose first element as pivot
     */
    public static int partition1(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i - 1, low);
        return i - 1;
    }

    /**
     * choose random element as pivot
     */
    public static int partition4(int[] a, int low, int high) {
        int index = low + new Random().nextInt(high - low);
        swap(a, low, index);
        return partition1(a, low, high);
    }


    /**
     * choose last element as pivot
     */
    public static int partition2(int[] a, int low, int high) {
        swap(a, low, high);
        return partition1(a, low, high);
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * choose median of three
     */
    public static int partition3(int[] a, int low, int high) {
        int index = getMedianOfThree(a, low, high);
        swap(a, index, low);
        return partition1(a, low, high);
    }

    public static int getMedianOfThree(int[] a, int low, int high) {
        int x = a[low];
        int y = a[high];
        int z = a[low + (high - low) / 2];
        int max = Math.max(Math.max(x, y), z);
        int min = Math.min(Math.min(x, y), z);

        if (min < x && x < max) {
            return low;
        } else if (min < y && y < max) {
            return high;
        } else {
            return low + (high - low) / 2;
        }
    }


    public static void main(String[] args) throws IOException {
        //162085
        //164123
        //138382
        String path = QuickSortComparision.class.getClassLoader().getResource("course1/assignment3/data/QuickSort.txt").getPath();
        int[] nums = Files.lines(Paths.get(path)).mapToInt(line -> Integer.parseInt(line)).toArray();
        long result = sort(nums);
        System.out.println(result);
    }
}

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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
        int j = high;
        while (i <= j) {
            if (a[i] < pivot) {
                i++;
            } else {
                swap(a, i, j);
                j--;
            }
        }
        swap(a, j, low);
        return j;
    }


    /**
     * choose last element as pivot
     */
    public static int partition2(int[] a, int low, int high) {
        int pivot = a[high];
        int i = low;
        int j = high - 1;
        while (i <= j) {
            if (a[i] < pivot) {
                i++;
            } else {
                swap(a, i, j);
                j--;
            }
        }
        swap(a, i, high);
        return i;
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
        swap(a, index, high);
        int pivot = a[high];
        int i = low;
        int j = high - 1;
        while (i <= j) {
            if (a[i] < pivot) {
                i++;
            } else {
                swap(a, i, j);
                j--;
            }
        }
        swap(a, i, high);
        return i;
    }

    public static int getMedianOfThree(int[] a, int low, int high) {
        int x = a[low];
        int y = a[high];
        int z = a[low + (high - low) / 2];
        if (x < y && x < z) {
            return low;
        } else if (y < x && y < z) {
            return high;
        } else {
            return low + (high - low) / 2;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "/Users/b0l00ev/Documents/personal/data/QuickSort.txt";
        List<String> list = Files.lines(Paths.get(path)).collect(Collectors.toList());
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(list.get(i));
        }
        long result = sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                System.out.println("array is not sorted");
            }
        }

        //       System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }
}

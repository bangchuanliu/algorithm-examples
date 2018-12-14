import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(a, low, high);
        sort(a, low, pivot - 1);
        sort(a, pivot + 1, high);
    }

    /**
     * choose last one as pivot
     **/
    public static int partition(int[] a, int low, int high) {
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

    /**
     * choose first one as pivot
     ***/
    public static int partition2(int[] a, int low, int high) {
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

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int randomizedPartition(int[] a, int low, int high) {
        int random = low + new Random().nextInt(high - low);
        swap(a, random, high);
        int pivot = a[random];
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

    public static void main(String[] args) {
        int[] a = {3, 8, 1, 7, 2, 9, 4, 5, 0};
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}

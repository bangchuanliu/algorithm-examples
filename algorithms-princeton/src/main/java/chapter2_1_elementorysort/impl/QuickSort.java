package chapter2_1_elementorysort.impl;

import chapter2_1_elementorysort.AbstractSort;

import java.util.Arrays;

public class QuickSort extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int r = partition(a, low, high);
        sort(a, low, r-1);
        sort(a, r + 1, high);
    }

    public int partition(Comparable[] a, int low, int high) {
        Comparable v = a[high];
        int i = low;
        int j = high - 1;
        while (i <= j) {
            if (less(a[i], v)) {
                i++;
            } else {
                exch(a, i, j);
                j--;
            }
        }
        exch(a, i, high);
        return i;
    }


    public static void main(String[] args) {
        Integer[] a = {6, 5, 2, 8, 0, 1, 8, 3, 9, 2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}

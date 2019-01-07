package chapter2_1_elementorysort.impl;

import chapter2_1_elementorysort.AbstractSort;

import java.util.Arrays;

public class MergeSort extends AbstractSort {

    public static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    /**
     * Bottom-up solution, iterative
     */
    public void sortBU(Comparable[] a) {
        aux = new Comparable[a.length];
        int N = a.length;
        for (int i = 1; i < a.length; i = i + i) {
            for (int low = 0; low < N - i; low += i + i) {
                merge(a, low, low + i - 1, Math.min(low + i + i - 1, N - 1));
            }
        }
    }

    /**
     * Top-Down solution, recursive
     */
    public void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    public void merge(Comparable[] a, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            aux[i] = a[i];
        }

        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {6, 5, 2, 8, 0, 1, 8, 3, 9, 2};
        Integer[] a2 = {6, 5, 2, 8, 0, 1, 8, 3, 9, 2};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        mergeSort.sortBU(a2);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a2));
    }
}

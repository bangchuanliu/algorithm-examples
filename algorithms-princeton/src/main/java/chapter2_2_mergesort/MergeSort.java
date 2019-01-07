package chapter2_2_mergesort;

import chapter2_1_elementorysort.AbstractSort;

public class MergeSort extends AbstractSort {

    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        topDownMergeSort(a, 0, a.length - 1);
    }

    public void topDownMergeSort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        topDownMergeSort(a, low, mid);
        topDownMergeSort(a, mid + 1, high);
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
        Integer[] a = {3, 6, 0, 0, 9, 7, 4, 8, 8};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        mergeSort.show(a);
    }
}

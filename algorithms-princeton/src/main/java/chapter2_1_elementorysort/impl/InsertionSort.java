package chapter2_1_elementorysort.impl;

import chapter2_1_elementorysort.AbstractSort;

public class InsertionSort extends AbstractSort {

    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {3, 6, 0, 0, 9, 7, 4, 8, 8};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(a);
        insertionSort.show(a);
    }
}

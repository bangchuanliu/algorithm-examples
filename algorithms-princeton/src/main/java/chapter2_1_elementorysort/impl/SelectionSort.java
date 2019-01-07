package chapter2_1_elementorysort.impl;

import chapter2_1_elementorysort.AbstractSort;

public class SelectionSort extends AbstractSort {
    
    @Override
    public void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int k = i;
            for (int j = i+1; j < a.length; j++) {
                if (less(a[j], a[k])) {
                    k = j;
                }
            }
            exch(a, i, k);
        }
    }
    
    public static void main(String[] args) {
        Integer[] a = {3,6,0,0,9,7,4,8,8};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(a);
        selectionSort.show(a);
    }
}

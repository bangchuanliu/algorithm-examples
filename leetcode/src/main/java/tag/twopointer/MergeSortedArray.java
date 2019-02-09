package tag.twopointer;

import java.util.Arrays;


/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p>
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 *
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 * @date Oct 30, 2014
 * 
 * @version 2.0
 * @since FEB, 5, 2019
 */
public class MergeSortedArray {

    /**
     * more readable
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0 && i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (k >= 0 && j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }


    public void merge2(int A[], int m, int B[], int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (k >= 0) {
            if (j < 0 || (i >= 0 && A[i] >= B[j])) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
    }


    public static void main(String[] args) {
        int A[] = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int B[] = {2, 4, 6, 8};
        new MergeSortedArray().merge(A, 5, B, 4);
        System.out.println(Arrays.toString(A));
    }


}

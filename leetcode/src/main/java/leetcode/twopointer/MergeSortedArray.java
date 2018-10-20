package leetcode.twopointer;

import java.util.Arrays;


/**
 *  Given two sorted integer arrays A and B, merge B into A as one sorted array.

	Note:
	You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
	The number of elements initialized in A and B are m and n respectively.
 * 
 * 
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Oct 30, 2014
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		int i = m -1;
		int j = n-1;
		int k = m + n -1;
		while(k >=0){
			if(j<0 || (i>=0 && A[i] >= B[j])){
				A[k--] = A[i--];
			}else{
				A[k--] = B[j--];
			}
		}
	}
	
	public static void main(String[] args){
		int A[] = {1,3,5,7,9,0,0,0,0,0,0,0,0,0,0,0,0};
		int B[] = {2,4,6,8};
		new MergeSortedArray().merge(A, 5, B, 4);
		System.out.println(Arrays.toString(A));
	}
	
	
	
}

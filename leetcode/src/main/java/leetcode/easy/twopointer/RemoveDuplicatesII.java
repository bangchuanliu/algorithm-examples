package leetcode.easy.twopointer;

import java.util.Arrays;

/**
 * 
 *  Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	
	Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author admin
 *
 */
public class RemoveDuplicatesII {
	
	
	/**
	 * i is the index
	 * compare current value and previous value
	 * 
	 * @param A
	 * @return
	 */
	public int removeDuplicates2(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		if(A.length <= 2){
			return A.length;
		}
		int i = 0;
		int j = 1;
		int count = 1;
		while(j<A.length){
			if(A[j-1] == A[j]){
				count++;
				if(count < 3){
					A[++i] = A[j];
				}
				j++;
			}else{
				A[++i] = A[j];
				j++;
				count = 1;
			}
		}
		return i+1;
	}
	
	// use two pointers
	public int removeDuplicates(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		if(A.length <= 2){
			return A.length;
		}
		int pre = 1;
		int curr = 2;
		while(curr < A.length){
			if(A[curr] == A[pre] && A[curr] == A[pre - 1]){
				curr++;
			}else{
				pre++;
				A[pre] = A[curr];
				curr++;
			}
		}
		return pre + 1;
	}
	
	public static void main(String[] args){
		RemoveDuplicatesII instance = new RemoveDuplicatesII();
	//	int[] A = {1,1,1,2,2,3};
	//	int[] A = {1,1,1,2,3};
	//	int[] A = {1,1,1,1};
		int[] A = {1,1,1,1,3,3};
		int len = instance.removeDuplicates2(A);
		System.out.println(len);
		System.out.println(Arrays.toString(A));
	}
}

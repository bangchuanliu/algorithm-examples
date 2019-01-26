package tag.dp;


/**
 * 
 *  Find the contiguous subarray within an array (containing at least one number) which has the largest product.

	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @author admin
 *
 */
public class MaxSubProductArray {
	
	public int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int max = A[0];
		int min = A[0];
		int global = A[0];
		for (int i = 1; i < A.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max*A[i], A[i]), A[i]*min);
			min = Math.min(Math.min(temp*A[i], A[i]), A[i]*min);
			global = Math.max(max, global);
		}
		return global;
	}
	
	public static void main(String[] args){
		MaxSubProductArray instance = new MaxSubProductArray();
		int[] arr = {2,3,-2,4};
		System.out.println(instance.maxProduct(arr));
	}
}

package leetcode.easy.binarysearch;

/**
 *  Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

	You may assume no duplicates in the array.
	
	Here are few examples.
	[1,3,5,6], 5 -> 2
	[1,3,5,6], 2 -> 1
	[1,3,5,6], 7 -> 4
	[1,3,5,6], 0 -> 0
 * 
 * @author admin
 *
 */
public class SearchInsertPosition {

	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int low = 0;
		int high = A.length - 1;
		int index = -1;
		while (low <= high) {
			int mid = (high + low) / 2;
			if (A[mid] == target) {
				return mid;
			} else if (A[mid] < target) {
				low = mid + 1;
				index = low; // use mid + 1
			} else {
				high = mid - 1;
				index = mid; // use mid
			}
		}

		return index < 0 ? 0 : index;
	}
	
	public static void main(String[] args){
		SearchInsertPosition instance = new SearchInsertPosition();
		int[] A = {1,3,5,7};
		System.out.println(instance.searchInsert(A, 0));
		System.out.println(instance.searchInsert(A, 1));
		System.out.println(instance.searchInsert(A, 2));
		System.out.println(instance.searchInsert(A, 3));
		System.out.println(instance.searchInsert(A, 4));
		System.out.println(instance.searchInsert(A, 5));
		System.out.println(instance.searchInsert(A, 6));
		System.out.println(instance.searchInsert(A, 7));
		System.out.println(instance.searchInsert(A, 8));
	}
}

package leetcode.twopointer;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author BangChuan Liu <liubangchuan1100@gmail.com>
 *
 * @date Feb 3, 2015
 */
public class RemoveElement {

	public static int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int i = 0;
		int j = 0;
		while (j < nums.length) {
			if (nums[j] != val) {
				nums[i] = nums[j];
				i++;
			} 
			j++;
		}
		return i;
	}

	public static void main(String[] args) {
		int[] A = { 2 };
		System.out.println(removeElement(A, 3));
	}
}

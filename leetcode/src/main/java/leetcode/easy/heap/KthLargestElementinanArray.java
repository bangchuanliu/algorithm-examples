package leetcode.easy.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * 
 * @author bliu13 Dec 9, 2015
 */
public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return 0;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		for (int i = 0; i < nums.length; i++) {
			if (i >= k) {
				minHeap.offer(nums[i]);
				minHeap.poll();
			} else {
				minHeap.offer(nums[i]);
			}
		}

		return minHeap.peek();
	}

	public static void main(String[] args) {
		KthLargestElementinanArray instance = new KthLargestElementinanArray();
		int[] nums = { 1, 2, 3, 4, 5 };

		int num = instance.findKthLargest(nums, 2);

		System.out.println(num);

	}

}

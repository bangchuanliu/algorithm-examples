package leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0 || k < 0) {
			return new int[0];
		}

		int[] arr = new int[nums.length - k + 1];

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}

		arr[0] = heap.peek();

		for (int i = k; i < nums.length; i++) {
			heap.remove(nums[i - k]);
			heap.offer(nums[i]);
			arr[i - k + 1] = heap.peek();
		}

		return arr;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum instance = new SlidingWindowMaximum();
		int[] matrix = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result = instance.maxSlidingWindow(matrix, 3);
		System.out.println(Arrays.toString(result));
	}
}

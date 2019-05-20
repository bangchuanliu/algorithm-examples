package tag.heap;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {


    /**
     * Deque
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }

        int[] arr = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            if (!q.isEmpty()) {
                while (!q.isEmpty() && nums[q.getLast()] < nums[i]) {
                    q.removeLast();
                }
            }
            q.add(i);
        }
        arr[0] = nums[q.getFirst()];
        for (int i = k; i < nums.length; i++) {
            if (!q.isEmpty() && q.getFirst() == i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && nums[q.getLast()] < nums[i]) {
                q.removeLast();
            }
            q.add(i);
            arr[i - k + 1] = nums[q.getFirst()];
        }

        return arr;
    }


    /**
     * heap
     * 
     */
	public int[] maxSlidingWindow2(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0) {
			return new int[0];
		}

		int[] arr = new int[nums.length - k + 1];

		PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b - a);

		for (int i = 0; i < k; i++) {
			heap.add(nums[i]);
		}

		arr[0] = heap.peek();

		for (int i = k; i < nums.length; i++) {
			heap.remove(nums[i - k]);
			heap.add(nums[i]);
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

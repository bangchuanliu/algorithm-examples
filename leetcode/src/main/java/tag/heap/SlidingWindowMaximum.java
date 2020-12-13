package tag.heap;

import java.util.*;

public class SlidingWindowMaximum {


    /**
     * Deque 
     *  1, 3, -1, -3, 5, 3, 6, 7
     */ 
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty()) {
                while (!q.isEmpty() && nums[q.getLast()] < nums[i]) {
                    q.removeLast();
                }
            }
            q.add(i);
            
            if(i >= k - 1) {
                result[i - k + 1] = nums[q.getFirst()];
                if(q.getFirst() == i - k + 1) {
                    q.removeFirst();
                }
            }
        }

        return result;
    }


    /**
     * heap
     * 
     */
	public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b -a);
        int[] result = new int[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);

            if(i >= k - 1) {
                result[i -k + 1] = pq.peek();
                pq.remove(nums[i - k + 1]);
            }
        }

        return result;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum instance = new SlidingWindowMaximum();
		int[] matrix = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int[] result = instance.maxSlidingWindow(matrix, 3);
        int[] result2 = instance.maxSlidingWindow2(matrix, 3);
		System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
	}
}

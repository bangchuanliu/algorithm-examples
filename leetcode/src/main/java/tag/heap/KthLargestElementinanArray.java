package tag.heap;

import java.util.PriorityQueue;

/**
 * @author bliu13 Dec 9, 2015
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return 0;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int i = 0;
        int j = nums.length - 1;
        int offset = k - 1;
        while (i <= j) {
            int index = partition(nums, i, j);

            if (index == offset) {
                return nums[index];
            } else if (index > offset) {
                j = index - 1;
            } else {
                i = index + 1;
            }
        }

        return -1;
    }



    public int partition(int[] nums, int low,  int high) {
        int pivot = nums[high];

        int i = low;
        int j = high - 1;

        while(i <= j) {
            if (nums[i] >= pivot) {
                i++;
            } else {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j--;
            }
        }
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high] = temp;

        return i;
    }
    
    
    public static void main(String[] args) {
        KthLargestElementinanArray instance = new KthLargestElementinanArray();
        int[] nums = {1, 2, 3, 4, 5};

        int num = instance.findKthLargest(nums, 2);

        System.out.println(num);

    }

}

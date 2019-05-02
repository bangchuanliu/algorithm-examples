package tag.binarysearch;

import java.util.Arrays;
import java.util.Random;

public class QuickSelect {
    
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,4,4,5};
        QuickSelect quickSelect = new QuickSelect();
        quickSelect.shuffle(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 3)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 0)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, 10)));
        
        System.out.println(quickSelect.findKthNum(nums, 1));
        System.out.println(quickSelect.findKthNum(nums, 2));
        System.out.println(quickSelect.findKthNum(nums, 3));
        System.out.println(quickSelect.findKthNum(nums, 4));
        System.out.println(quickSelect.findKthNum(nums, 5));
        System.out.println(quickSelect.findKthNum(nums, 6));
        System.out.println(quickSelect.findKthNum(nums, 7));
        System.out.println(quickSelect.findKthNum(nums, 8));
        System.out.println(quickSelect.findKthNum(nums, 9));
    }
    
    
    public void shuffle(int[] nums) {
        Random ran = new Random();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = ran.nextInt(i+1);
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
    
    public int findKthNum(int[] nums, int k) {
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
                offset = offset - index - 1;
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
            if (nums[i] <= pivot) {
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
}

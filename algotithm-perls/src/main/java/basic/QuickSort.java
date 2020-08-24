package basic;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {4,7,1,9,2,3};
        sort(nums, nums.length - 1, 0);
        
        System.out.println(Arrays.toString(nums));
    }
    
    public static void sort(int[] nums, int high, int low){
        if(low <= high){
            int pivot = partition(nums, high, low);
            sort(nums, pivot - 1, low);
            sort(nums, high, pivot +1);
        }
    }
    
    public static int partition(int[] nums, int high, int low){
        int r = nums[high];
        int i = low- 1;
        int j = low;
        while (j < high) {
            if (nums[j] <= r) {
                i++;
                swap(nums, j, i);           
            }
            j++;
        }
        i++;
        swap(nums, high, i);
        return i;
    }
    
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

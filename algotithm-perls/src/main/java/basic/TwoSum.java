package basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums =  {3,4,5,6,7,1,2};
        System.out.println(Arrays.toString(twoSum(nums, 3)));
    }
    
    
    public static int[] twoSum(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return null;
        }
        
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if (i != j && nums[i] + nums[j] == target){
                    return new int[]{i,j };
                }
            }
        }
        
        return null;
    }
}

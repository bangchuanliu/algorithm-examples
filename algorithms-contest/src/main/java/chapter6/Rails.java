package chapter6;


import java.util.Stack;

/**
 * UVA514
 */
public class Rails {

    public static void main(String[] args) {
        int[] nums = {4,3,5,1,2,0};
        System.out.println(isValidOrder(nums));
    }
    
    
    public static boolean isValidOrder(int[] nums){
        if (nums == null || nums.length == 0){
            return false;
        }
        
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        
        while (j < nums.length){
           if (i == nums[j]) {
               i++;
               j++;
           }else if (!stack.isEmpty() && stack.peek() == nums[j]){
               stack.pop();
               j++;
           }else if (i < nums.length){
               stack.push(i);
               i++;
           }else{
               return false;
           }
        }
        
        return true;
    }
}

package monostack;

import java.util.Arrays;
import java.util.Stack;

public class MonoStack {
    public static void main(String[] args) {
        int[] nums = {5,3,1,2,4};
        System.out.println(Arrays.toString(nextFirstLargerElement(nums))); // -1 3 1 1 -1
        System.out.println(Arrays.toString(nextFirstSmallerElement(nums))); // 1 1 -1 -1 -1
        System.out.println(Arrays.toString(previousFirstLargerElement(nums))); // -1 1 1 2 4
        System.out.println(Arrays.toString(previousFirstSmallerElement(nums))); // -1 -1 -1 1 1
    }
    
    
    public static int[] nextFirstLargerElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    int index = stack.peek();
                    result[stack.pop()] = i - index;
                }
            }
            stack.push(i);
        }
        return result;
    }
    
    public static int[] nextFirstSmallerElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    int index = stack.peek();
                    result[stack.pop()] = i - index;
                }
            }
            stack.push(i);
        }
        
        return result;
    }
    
    public static int[] previousFirstLargerElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    int index = stack.peek();
                    result[stack.pop()] = index - i;
                }
            }
            stack.push(i);
        }
        return result;
    }
    
    public static int[] previousFirstSmallerElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for(int i = nums.length - 1; i >= 0; i--) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    int index = stack.peek();
                    result[stack.pop()] = index - i;
                }
            }
            stack.push(i);
        }

        return result;
    }
 }

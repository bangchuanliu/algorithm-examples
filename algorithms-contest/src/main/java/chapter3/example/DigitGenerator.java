package chapter3.example;

public class DigitGenerator {
    
    public static int[] digitGenerator() {
        int[] nums = new int[1000001];
        
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int x = i;
            
            while (x > 0) {
                j += x % 10;
                x = x / 10;
            }
            
            if (j < nums.length && nums[j] == 0) nums[j] = i; 
        }
        
        return nums;
    }
    
    public static void main(String[] args) {
        int[] nums = digitGenerator();
        System.out.println(nums[216]);
        System.out.println(nums[121]);
        System.out.println(nums[2005]);
    }
}

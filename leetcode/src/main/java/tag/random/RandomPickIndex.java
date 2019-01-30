package tag.random;

public class RandomPickIndex {
    
    private int[] nums;
    
    public RandomPickIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int i = 0;
        while (i < nums.length && nums[i] != target) {
            i++;
        }
        int candidate = i;
        i++;
        double count = 1;
        while (i < nums.length) {
            if (nums[i] == target) {
                count++;
                double ran = Math.random();
                if (ran <= 1/count) {
                    candidate = i;
                }
            }
            i++;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,3};
        RandomPickIndex solution = new RandomPickIndex(nums);
        System.out.println(solution.pick(3));

    }
}

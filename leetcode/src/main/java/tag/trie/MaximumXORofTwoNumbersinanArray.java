package tag.trie;

public class MaximumXORofTwoNumbersinanArray {

    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }
        
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        MaximumXORofTwoNumbersinanArray maximumXORofTwoNumbersinanArray = new MaximumXORofTwoNumbersinanArray();
        System.out.println(maximumXORofTwoNumbersinanArray.findMaximumXOR(nums));
    }
}

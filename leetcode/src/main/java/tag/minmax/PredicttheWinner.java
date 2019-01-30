package tag.minmax;

public class PredicttheWinner {
    
    public boolean PredictTheWinner(int[] nums) {
        
//        return PredictTheWinner(nums, 0, nums.length - 1, 1) >= 0;
        int[][] cached = new int[nums.length][nums.length];
        return PredictTheWinner2(nums, 0, nums.length - 1,cached) >= 0;
    }

    public int PredictTheWinner(int[] nums, int i, int j, int turn) {
        if (i == j) {
            return nums[i] * turn;
        }
        
        int a =turn * nums[i] +  PredictTheWinner(nums, i+1, j, -turn);
        int b = turn * nums[j] + PredictTheWinner(nums, i, j-1, -turn);
        
        return turn * Math.max(turn * a, turn * b);
    }

    public int PredictTheWinner2(int[] nums, int i, int j, int[][] cached) {
        if (i == j) {
            return nums[i];
        }
        if (cached[i][j]!=0) {
            return cached[i][j];
        }

        int a =nums[i] -  PredictTheWinner2(nums, i+1, j, cached);
        int b = nums[j] - PredictTheWinner2(nums, i, j-1, cached);
        
        int max = Math.max(a, b);
        cached[i][j] = max;
        return max;
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 233, 7};
        PredicttheWinner predicttheWinner = new PredicttheWinner();
        System.out.println(predicttheWinner.PredictTheWinner(nums));
    }
}

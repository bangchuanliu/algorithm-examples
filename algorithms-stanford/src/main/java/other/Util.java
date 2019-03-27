package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {

    public static void main(String[] args) {
        int[][] edges ={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        System.out.println(Arrays.toString(maxCoins(6, edges).toArray()));
    }


    public int maxCoins(int[] nums) {
        
    }

    int max = Integer.MIN_VALUE;
    public int dfs(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        for (int i = left; i <= right; i++) {
            int left = i == 0? 1 : nums.get(i-1);
            int right = i == list.size()-1? 1 : list.get(i+1);
            int sum = left * list.get(i) * right;
            List<Integer> newList = new ArrayList<>(list);
            newList.remove(new Integer(list.get(i)));
            int prod = dfs(newList);
            max = Math.max(max, sum + prod);
        }
    }
    
}

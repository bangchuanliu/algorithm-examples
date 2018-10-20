package leetcode.tree;

import common.TreeNode;

/**
 * Created by bliu on 3/30/16.
 */
public class HouseRobberIII {
    
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root)[0];
    }

    public int[] dfs(TreeNode root) {
        int[] dp = {0,0};
        if (root == null) {
            return dp;
        }

        int[] dpL = dfs(root.left);
        int[] dpR = dfs(root.right);
        dp[1] = dpL[0] + dpR[0];
        dp[0] = Math.max(dp[1], root.val + dpL[1] + dpR[1]);
        return dp;
    }
}

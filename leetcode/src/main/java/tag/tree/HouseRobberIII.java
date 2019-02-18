package tag.tree;

import common.TreeNode;

/**
 * Created by bliu on 3/30/16.
 */
public class HouseRobberIII {
    
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root)[0];
    }
    //dp[0] : max of current node as root
    // dp[1] : max of left and right nodes as root
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

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum2  = root.val;
        int sum1  = 0;
        if (root.left != null) {
            sum1 += rob(root.left);
            sum2 += rob(root.left.left) + rob(root.left.right);
        }

        if (root.right != null) {
            sum1 += rob(root.right);
            sum2 += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(sum1, sum2);
    }
}

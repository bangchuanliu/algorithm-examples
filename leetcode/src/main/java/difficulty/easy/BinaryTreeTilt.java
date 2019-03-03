package difficulty.easy;

import common.TreeNode;

public class BinaryTreeTilt {
    
    int sum = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        sum += Math.abs(left - right);

        return root.val + left + right;
    }
}

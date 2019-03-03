package tag.tree;

import common.TreeNode;

public class BinaryTreeMaximumPathSum {
    
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxsum(root);
        return max;
    }

    public int maxsum (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(maxsum(root.left),0);
        int right = Math.max(maxsum(root.right),0);

        int temp = root.val + left + right;

        max = Math.max(max, temp);

        return root.val + Math.max(left, right);
    }
}

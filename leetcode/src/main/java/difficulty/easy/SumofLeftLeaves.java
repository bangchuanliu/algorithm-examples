package difficulty.easy;

import common.TreeNode;

public class SumofLeftLeaves {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumOfLeftLeaves(root, null);
    }

    public int sumOfLeftLeaves(TreeNode node, TreeNode p) {
        if (node == null) {
            return 0;
        }
        if (p != null) {
            if (node.left == null && node.right == null && node == p.left) {
                return node.val;
            }
        }

        int left = sumOfLeftLeaves(node.left, node);
        int right = sumOfLeftLeaves(node.right, node);

        return left + right;
    }

}

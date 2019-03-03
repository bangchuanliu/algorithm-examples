package difficulty.easy;

import common.TreeNode;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return leaf(root1).equals(leaf(root2));
    }

    public String leaf(TreeNode root1) {
        if (root1 == null) {
            return "";
        }

        String left = leaf(root1.left);
        String right = leaf(root1.right);

        if (root1.left == null && root1.right == null) {
            return root1.val + "";
        }

        return left + right;
    }
}

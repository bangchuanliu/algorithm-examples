package tag.tree;

import common.TreeNode;

public class ConvertBSTtoGreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);

        return root;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}

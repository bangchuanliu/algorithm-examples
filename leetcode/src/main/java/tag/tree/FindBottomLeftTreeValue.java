package tag.tree;

import common.TreeNode;

public class FindBottomLeftTreeValue {

    int height = Integer.MIN_VALUE;
    TreeNode node = null;

    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root, 0);
        return node.val;
    }

    public void findBottomLeftValue(TreeNode root, int h) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && h > height) {
            height = h;
            node = root;
        }

        findBottomLeftValue(root.left, h + 1);
        findBottomLeftValue(root.right, h + 1);
    }
}

package tag.recursive;

import common.TreeNode;

public class LongestUnivaluePath {
    static int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        arrow(root);

        return max;
    }

    public int arrow(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = arrow(node.left);
        int right = arrow(node.right);
        int aLeft = 0;
        int aRight = 0;
        if (node.left != null && node.left.val == node.val) {
            aLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            aRight += right + 1;
        }
        max = Math.max(max, aLeft + aRight);

        return Math.max(aLeft, aRight);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        LongestUnivaluePath instance = new LongestUnivaluePath();
        System.out.println(instance.longestUnivaluePath(node));
    }
}

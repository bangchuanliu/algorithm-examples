package difficulty.easy;

import common.TreeNode;
import common.TreeNodeUtil;

public class DiameterofBinaryTree {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        DiameterofBinaryTree diameterofBinaryTree = new DiameterofBinaryTree();
        Integer[] nums = {1, 2, 3, 4, 5};
        TreeNode root = TreeNodeUtil.creatTree(nums);
        System.out.println(diameterofBinaryTree.diameterOfBinaryTree(root));
    }
}

package difficulty.easy;

import common.TreeNode;
import common.TreeNodeUtil;

public class DiameterofBinaryTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        max = Math.max(max, maxDepth(root.left) + maxDepth(root.right));

        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        max = Math.max(max, Math.max(left, right));
        return max;
    }



    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        return Math.max(maxL, maxR) + 1;
    }
    
    public static void main(String[] args) {
        DiameterofBinaryTree diameterofBinaryTree = new DiameterofBinaryTree();
        Integer[] nums = {1,2,3,4,5};
        TreeNode root = TreeNodeUtil.creatTree(nums);
        System.out.println(diameterofBinaryTree.diameterOfBinaryTree(root));
    }
}

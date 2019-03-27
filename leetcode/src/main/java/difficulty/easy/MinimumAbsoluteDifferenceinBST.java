package difficulty.easy;

import common.TreeNode;

public class MinimumAbsoluteDifferenceinBST {

    int min = Integer.MAX_VALUE;
    Integer pre;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }


    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (pre != null) {
            min = Math.min(min, Math.abs(pre - root.val));
        }
        pre = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(236);
        TreeNode n2 = new TreeNode(104);
        TreeNode n3 = new TreeNode(227);
        TreeNode n4 = new TreeNode(701);
        TreeNode n5 = new TreeNode(911);

        n1.left = n2;
        n1.right = n4;
        n2.right = n3;
        n4.right = n5;


    }
}

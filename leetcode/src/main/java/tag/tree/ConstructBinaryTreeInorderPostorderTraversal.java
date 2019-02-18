package tag.tree;

import java.util.Arrays;

import common.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note: You may assume that duplicates do not exist in the tree.
 *
 * @author bangchuanliu
 */
public class ConstructBinaryTreeInorderPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int i, int j, int[] postorder, int l, int r) {
        if (i > j || l > r) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r]);
        int k = i;
        while (k <= j && inorder[k] != postorder[r]) {
            k++;
        }
        root.left = buildTree(inorder, i, k - 1, postorder, l, l + k - i - 1);
        root.right = buildTree(inorder, k + 1, j, postorder, l + k - i, r - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeInorderPostorderTraversal instance = new ConstructBinaryTreeInorderPostorderTraversal();
        int[] inorder = {3, 2, 1};
        int[] postorder = {3, 2, 1};
        TreeNode root = instance.buildTree(inorder, postorder);
        System.out.println(root.val);
    }
}

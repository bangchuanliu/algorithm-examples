package leetcode.easy.tree;

import java.util.Arrays;

import common.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author bangchuanliu
 *
 */
public class ConstructBinaryTreeInorderPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || postorder.length == 0 || inorder.length == 0) {
			return null;
		}
		int val = postorder[postorder.length - 1];
		TreeNode root = new TreeNode(val);
		int index = 0;
		while (index < inorder.length) {
			if (inorder[index] == val) {
				break;
			}
			index++;
		}
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
		int[] rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
		int[] rightPostorder = Arrays.copyOfRange(postorder, index, postorder.length - 1);
		TreeNode left = buildTree(leftInorder, leftPostorder);
		TreeNode right = buildTree(rightInorder, rightPostorder);
		root.left = left;
		root.right = right;
		return root;
	}

	public static void main(String[] args) {
		ConstructBinaryTreeInorderPostorderTraversal instance = new ConstructBinaryTreeInorderPostorderTraversal();
		int[] inorder = { 1, 2 };
		int[] postorder = { 2, 1 };
		TreeNode root = instance.buildTree(inorder, postorder);
	}
}

package difficulty.easy;

import common.TreeNode;

/**
 * 
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * 
 * @author bliu13 Jan 12, 2016
 */
public class InvertBinaryTree {

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		invertTree(root.left);
		invertTree(root.right);

		return root;
	}

	public TreeNode invertTree2(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = invertTree2(root.left);
		TreeNode right = invertTree2(root.right);
		
		root.left = right;
		root.right = left;

		return root;
	}
}

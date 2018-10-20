package leetcode.tree;

import common.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root
 * 
 * node down to the farthest leaf node.
 * 
 */
public class MaxTreeDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxL = maxDepth(root.left);
		int maxR = maxDepth(root.right);
		return Math.max(maxL, maxR) + 1;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode next = root;
		for (int i = 0; i < 1000; i++) {
			TreeNode node = new TreeNode(1);
			next.left = node;
			next = node;
		}
		MaxTreeDepth instance = new MaxTreeDepth();
		System.out.println(instance.maxDepth(root));
	}
}

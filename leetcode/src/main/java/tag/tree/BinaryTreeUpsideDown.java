package tag.tree;

import common.TreeNode;

public class BinaryTreeUpsideDown {

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if (root == null || root.left == null) {
			return root;
		}
		TreeNode left = root.left;

		TreeNode ret = upsideDownBinaryTree(left);

		left.left = root.right;
		left.right = root;
		root.left = null;
		root.right = null;

		return ret;
	}

	/**
	 * iterative
	 * 
	 * @param root
	 * @return
	 */
	public TreeNode upsideDownBinaryTree3(TreeNode root) {
		TreeNode node = root, parent = null, right = null;
		while (node != null) {
			TreeNode left = node.left;
			node.left = right;
			right = node.right;
			node.right = parent;
			parent = node;
			node = left;
		}
		return parent;
	}

	public TreeNode upsideDownBinaryTree2(TreeNode root) {
		if (root == null) {
			return null;
		}
		return upsideDownBinaryTree2(null, root);
	}

	public TreeNode upsideDownBinaryTree2(TreeNode parent, TreeNode node) {
		if (node == null) {
			return parent;
		}
		TreeNode root = upsideDownBinaryTree2(node, node.left);
		if (node.left != null) {
			TreeNode right = node.right;
			node.left.left = right;
			node.left.right = node;
			node.left = null;
			node.right = null;
		}
		return root;
	}
}

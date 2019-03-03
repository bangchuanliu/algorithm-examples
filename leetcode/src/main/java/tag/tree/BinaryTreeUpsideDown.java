package tag.tree;

import common.TreeNode;
import common.TreeNodeUtil;

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
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
        BinaryTreeUpsideDown instance = new BinaryTreeUpsideDown();
		TreeNode root = instance.upsideDownBinaryTree(n1);
        TreeNodeUtil.printTree(root);
	}
}

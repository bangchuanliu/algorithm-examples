package tag.tree;

import common.TreeNode;

/**
 * 
 *  Given a binary tree, determine if it is a valid binary search tree (BST).

	Assume a BST is defined as follows:
	
	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.
 * 
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class ValidateBinarySearchTree {
	
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE,Long.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode root, Long min, Long max){
		if(root == null){
			return true;
		}
		if(root.val <= min || root.val >= max){
			return false;
		}
		
		return isValidBST( root.left,  min,  (long)root.val) && isValidBST( root.right,  (long)root.val,  max);
	}
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n5.right = n6;
		n3.left = n7;
		n3.right = n8;
		ValidateBinarySearchTree instance = new ValidateBinarySearchTree();
		instance.isValidBST(n1);
	}
}

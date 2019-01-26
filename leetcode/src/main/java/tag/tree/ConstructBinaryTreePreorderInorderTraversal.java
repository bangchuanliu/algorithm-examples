package tag.tree;

import common.TreeNode;

/**
 *  Given preorder and inorder traversal of a tree, construct the binary tree.

	Note:
	You may assume that duplicates do not exist in the tree.
 * 
 * @author admin
 *
 */
public class ConstructBinaryTreePreorderInorderTraversal {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(inorder == null || preorder == null || preorder.length == 0 || inorder.length == 0){
			return null;
		}
		return buildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length - 1);
	}
	
	public TreeNode buildTree(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
		if(startPre > endPre || startIn > endIn){
			return null;
		}
		int val = preorder[startPre];
		TreeNode root = new TreeNode(val);
		int index = 0;
		while(index <= inorder.length){
			if(inorder[index] == val){
				break;
			}
			index++;
		}
		TreeNode left = buildTree(preorder,startPre+1,startPre+(index-startIn),inorder,startIn,index-1);
		TreeNode right = buildTree(preorder,startPre+(index-startIn)+1,endPre,inorder,index+1,endIn);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String[] args){
		ConstructBinaryTreePreorderInorderTraversal instance = new ConstructBinaryTreePreorderInorderTraversal();
		int[] inorder = {1,2};
		int[] preorder = {1,2};
		TreeNode root = instance.buildTree(preorder, inorder);
	}
}

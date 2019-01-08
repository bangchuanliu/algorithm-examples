package leetcode.easy.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import common.TreeNode;


/**
 * 
 *  Given a binary tree, return the inorder traversal of its nodes' values.

	For example:
	Given binary tree {1,#,2,3},
	   1
	    \
	     2
	    /
	   3
	return [1,3,2].
	
	Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author BangChuan Liu 
 * @date   2015
 * @Contact liubangchuan1100@gmail.com
 */
public class BinaryTreeInorderTraversal {
	
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(!stack.isEmpty() || p!= null){
			if(p != null){
				stack.push(p);
				p = p.left;
			}else{
				TreeNode cur = stack.pop();
				result.add(cur.val);
				p = cur.right;
			}
		}
		return result;
	}
	
	public static void main(String[] args){
		BinaryTreeInorderTraversal instance = new BinaryTreeInorderTraversal();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.right = n2;
		n2.left= n3;
		List<Integer> result = instance.inorderTraversal(n1);
		System.out.println(Arrays.toString(result.toArray()));
	}
}

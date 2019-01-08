package leetcode.easy.tree;

import java.util.Stack;

import common.TreeNode;

public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode dummy = new TreeNode(0);
        TreeNode p = dummy;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            p.right = node;
            p = p.right;
            if (node.right != null) {
                stack.push(node.right);
            } 
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        
        dummy = null;
    }
	
	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList instance = new FlattenBinaryTreetoLinkedList();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.right = n6;
		instance.flatten(n1);
		
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.right;
		}
	}
	
}

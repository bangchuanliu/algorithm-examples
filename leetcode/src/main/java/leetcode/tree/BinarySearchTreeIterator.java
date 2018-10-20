package leetcode.tree;

import java.util.Stack;

import common.TreeNode;

public class BinarySearchTreeIterator {
	Stack<TreeNode> stack = new Stack<>();

	public BinarySearchTreeIterator(TreeNode root) {
	        TreeNode p = root;
	        if (root != null) {
	            while (p != null) {
	                stack.push(p);
	                p = p.left;
	            }
	        }
	    }

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode p = node.right;
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
			return node.val;
		} else {
			return 0;
		}
	}
}

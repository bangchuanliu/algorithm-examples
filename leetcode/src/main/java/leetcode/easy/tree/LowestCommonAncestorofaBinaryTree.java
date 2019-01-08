package leetcode.easy.tree;

import java.util.Stack;

import common.TreeNode;

public class LowestCommonAncestorofaBinaryTree {

	/**
	 * Recursive
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		return left == null ? right : left;
	}

	/**
	 * post order traversal
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}

		Stack<TreeNode> stack1 = findPath(root, p);
		Stack<TreeNode> stack2 = findPath(root, q);
		int len1 = stack1.size();
		int len2 = stack2.size();
		int len = Math.min(len1, len2);

		while (len1 > len) {
			stack1.pop();
			len1--;
		}

		while (len2 > len) {
			stack2.pop();
			len2--;
		}

		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			if (stack1.peek() == stack2.peek()) {
				return stack1.peek();
			}
			stack1.pop();
			stack2.pop();
		}
		return root;
	}

	public Stack<TreeNode> findPath(TreeNode root, TreeNode node) {
		Stack<TreeNode> stack = new Stack<>();

		if (root == null || node == null) {
			return stack;
		}

		stack.push(root);
		TreeNode pre = null;

		while (!stack.isEmpty()) {
			TreeNode curr = stack.peek();

			if (curr == node) {
				return stack;
			}

			if (pre == null || pre.left == curr || pre.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
				}
			} else if (curr.left == pre) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					stack.pop();
				}
			} else if (curr.right == pre) {
				stack.pop();
			}

			pre = curr;
		}

		return stack;
	}
}

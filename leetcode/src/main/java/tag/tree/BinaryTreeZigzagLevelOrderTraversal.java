package tag.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		int level = 1;
		LinkedList<TreeNode> currentStack = new LinkedList<TreeNode>();
		LinkedList<TreeNode> nextStack = new LinkedList<TreeNode>();
		LinkedList<TreeNode> tmp;

		currentStack.push(root);

		while (!currentStack.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			while (!currentStack.isEmpty()) {
				TreeNode node = currentStack.pop();
				int val = node.val;
				temp.add(val);
				if (level == 1) {
					if (node.left != null) {
						nextStack.push(node.left);
					}

					if (node.right != null) {
						nextStack.push(node.right);
					}
				} else {
					if (node.right != null) {
						nextStack.push(node.right);
					}

					if (node.left != null) {
						nextStack.push(node.left);
					}
				}
			}

			result.add(temp);
			level = ~level;
			tmp = currentStack;
			currentStack = nextStack;
			nextStack = tmp; // current stack already pop all the elements
		}
		return result;
	}
}

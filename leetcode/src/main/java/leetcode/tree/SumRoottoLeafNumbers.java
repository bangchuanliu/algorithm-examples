package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class SumRoottoLeafNumbers {

	public int sumNumbers(TreeNode root) {

		if (root == null) {
			return 0;
		}

		List<Integer> result = new ArrayList<>();

		sumNumbers(root, result, root.val);

		int sum = 0;
		for (int num : result) {
			sum += num;
		}

		return sum;
	}

	public void sumNumbers(TreeNode node, List<Integer> result, int num) {

		if (node.left == null && node.right == null) {
			result.add(num);
			return;
		}

		if (node.left != null) {
			num = num * 10 + node.left.val;
			sumNumbers(node.left, result, num);
			num = (num) / 10;
		}

		if (node.right != null) {
			num = num * 10 + node.right.val;
			sumNumbers(node.right, result, num);
			num = num / 10;
		}
	}
}

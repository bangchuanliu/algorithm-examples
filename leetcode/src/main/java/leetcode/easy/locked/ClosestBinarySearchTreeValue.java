package leetcode.easy.locked;

import common.TreeNode;

public class ClosestBinarySearchTreeValue {
	
	public int findClosetValue(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}
		
		if (val > root.val) {
			if (root.right != null && val > root.right.val) {
				return findClosetValue(root.right,val);
			} else {
				return getClosetValue(root.left);
			}
		} else if (val < root.val) {
			if (root.left != null && val < root.left.val) {
				return findClosetValue(root.left, val);
			} else {
				return val;
			}
		} else {
			return val;
		}
	}
	
	public int getClosetValue(TreeNode node) {
		int val = 0;
		while (node != null) {
			val = node.val;
			node = node.right;
		}
		
		return val;
	}
}

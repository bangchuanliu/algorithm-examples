package leetcode.easy.tree;

import common.TreeNode;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = leftHeight(root);
        int right = rightHeight(root);
        
        if (left == right) {
        	return (2<<(left - 1)) - 1;
        } else {
        	return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

	public int leftHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int len = 0;
		while (root != null) {
			len++;
			root = root.left;
		}
		return len;
	}
	
	public int rightHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int len = 0;
		while (root != null) {
			len++;
			root = root.right;
		}
		return len;
	}
}

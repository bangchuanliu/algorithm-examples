package leetcode.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class MinimumDepthofBinaryTree {

	/**
	 * DFS
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		} else if (root.left != null && root.right == null) {
			return minDepth(root.left) + 1;
		} else if (root.left == null && root.right != null) {
			return minDepth(root.right) + 1;
		} else {
			int minL = minDepth(root.left);
			int minR = minDepth(root.right);
			return Math.min(minL, minR) + 1;
		}
	}

	/**
	 * BFS
	 * 
	 * @param root
	 * @return
	 */
	public int minDepth2(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int hight = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return hight;
				}

				if (node.left != null) {
					queue.offer(node.left);
				}

				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			hight++;
		}
		return hight;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode next = root;
		for (int i = 0; i < 1000; i++) {
			TreeNode node = new TreeNode(1);
			next.left = node;
			next = node;
		}
		System.out.println(new MinimumDepthofBinaryTree().minDepth(root));
	}
}

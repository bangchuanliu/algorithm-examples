package leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * root -> bottom
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> orderList = new ArrayList<List<Integer>>();
		if (root == null) {
			return orderList;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int c = 1;
		int cc = 0;
		while (!queue.isEmpty()) {
			cc = 0;
			List<Integer> temp = new ArrayList<Integer>();
			while (c > 0) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left != null) {
					cc++;
					queue.add(node.left);
				}
				if (node.right != null) {
					cc++;
					queue.add(node.right);
				}
				c--;
			}
			orderList.add(temp);
			c = cc;
		}
		return orderList;
	}

	/**
	 * bottom -> root
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> orderList = new ArrayList<List<Integer>>();
		if (root == null) {
			return orderList;
		}
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int c = 1;
		int cc = 0;
		while (!queue.isEmpty()) {
			cc = 0;
			List<Integer> temp = new ArrayList<Integer>();
			while (c > 0) {
				TreeNode node = queue.poll();
				temp.add(node.val);
				if (node.left != null) {
					cc++;
					queue.add(node.left);
				}
				if (node.right != null) {
					cc++;
					queue.add(node.right);
				}
				c--;
			}
			orderList.add(temp);
			c = cc;
		}
		Collections.reverse(orderList);
		return orderList;
	}

	public List<List<Integer>> levelOrder3(TreeNode root) {
		List<List<Integer>> nodesList = new ArrayList<>();

		if (root == null) {
			return nodesList;
		}

		Queue<TreeNode> nodesQ = new LinkedList<TreeNode>();
		nodesQ.offer(root);
		
		while (!nodesQ.isEmpty()) {
			List<Integer> curList = new ArrayList<>();
			int size = nodesQ.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = nodesQ.poll();
				curList.add(node.val);
				if (node.left != null) {
					nodesQ.offer(node.left);
				}

				if (node.right != null) {
					nodesQ.offer(node.right);
				}
			}
			nodesList.add(new ArrayList<Integer>(curList));
		}

		return nodesList;
	}
}

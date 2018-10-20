package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> values = new ArrayList<>();

		if (root == null) {
			return values;
		}
		
		Queue<TreeNode> nodesQ = new LinkedList<>();
		nodesQ.add(root);
		
		while (!nodesQ.isEmpty()) {
			int size = nodesQ.size();
			values.add(nodesQ.peek().val);
			for (int i = 0; i < size; i++) {
				TreeNode node = nodesQ.poll();
				
				if (node.right != null) {
					nodesQ.add(node.right);
				} 
				if (node.left != null) {
					nodesQ.add(node.left);
				}
			}
		}
		
		return values;
	}
}

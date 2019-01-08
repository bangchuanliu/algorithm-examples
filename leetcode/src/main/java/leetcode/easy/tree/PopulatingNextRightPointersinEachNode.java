package leetcode.easy.tree;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}

		connect(root, null);
	}

	public void connect(TreeLinkNode node, TreeLinkNode parent) {
		if (node == null) {
			return;
		}

		if (parent != null) {
			if (node == parent.left) {
				node.next = parent.right;
			} else if (parent.next != null) {
				node.next = parent.next.left;
			}
		}
		
		connect(node.left, node);

		connect(node.right, node);
	}

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
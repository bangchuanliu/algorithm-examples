package tag.tree;

public class PopulatingNextRightPointersinEachNode {
	public void connect(Node root) {

		if (root == null) {
			return;
		}

		connect(root, null);
	}

	public void connect(Node node, Node parent) {
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

	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {}

		public Node(int _val,Node _left,Node _right,Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}
	};
}
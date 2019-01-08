package leetcode.easy.tree;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class SerializeandDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.substring(0, sb.length() - 1);
	}

	public void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("#,");
		} else {
			sb.append(root.val).append(",");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.trim().length() == 0) {
			return null;
		}
		String[] values = data.split(",");
		Queue<String> queue = new LinkedList<>();
		for (String str : values) {
			queue.offer(str);
		}
		return deserialize(queue);
	}

	public TreeNode deserialize(Queue<String> queue) {
		TreeNode node = null;
		if (!queue.isEmpty()) {
			String str = queue.poll();

			if (!"#".equals(str)) {
				int val = Integer.parseInt(str);
				node = new TreeNode(val);
				TreeNode left = deserialize(queue);
				TreeNode right = deserialize(queue);
				node.left = left;
				node.right = right;
			}
		}
		return node;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(1);

		n1.left = n2;
		n1.right = n3;
		n3.left = n4;
		n3.right = n5;
		n4.left = n6;
		n4.right = n7;

		SerializeandDeserializeBinaryTree instance = new SerializeandDeserializeBinaryTree();
		String serializedStr = instance.serialize(n1);
		System.out.println(serializedStr);
		TreeNode root = instance.deserialize(serializedStr);
		System.out.println(instance.serialize(root));
	}
}

package tag.tree;

import common.TreeNode;

public class FlattenBinaryTreetoLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            TreeNode temp = root.left;
            while (temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        flatten(root.right);
    }

	public void flatten2(TreeNode root) {
		if (root == null) {
			return;
		}

		flatten(root.left);
		flatten(root.right);

		TreeNode right = root.right;
		TreeNode left = root.left;
		TreeNode node = left;
		while(node != null && node.right != null) {
			node = node.right;
		}

		if (node != null) {
			root.right = left;
			node.right = right;
			root.left = null;
		}
	}

    public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList instance = new FlattenBinaryTreetoLinkedList();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		n1.left = n2;
		n1.right = n5;
		n2.left = n3;
		n2.right = n4;
		n5.right = n6;
		instance.flatten(n1);
		
		while (n1 != null) {
			System.out.println(n1.val);
			n1 = n1.right;
		}
	}
}

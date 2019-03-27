package tag.bst;

import common.TreeNode;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    TreeNode pre;
    TreeNode head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        head = new TreeNode(-1);
        pre = head;
        head.right = root;
        visit(root);
        pre.right = head.right;
        head.right.left = pre;
        return head.right;
    }


    public void visit(TreeNode root) {
        if (root == null) {
            return;
        }
        visit(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        visit(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n4.right = n5;
        n4.left = n2;
        n2.left = n1;
        n2.right = n3;

        ConvertBinarySearchTreetoSortedDoublyLinkedList instance = new ConvertBinarySearchTreetoSortedDoublyLinkedList();
        TreeNode node = instance.treeToDoublyList(n4);
        for (int i = 0; i < 5; i++) {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }
}

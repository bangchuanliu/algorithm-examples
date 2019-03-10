package tag.tree;

import common.ListNode;
import common.TreeNode;


/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * @author admin
 */
public class ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        if (pre != null) {
            pre.next = null;
            root.left = sortedListToBST(head);
        }

        if (slow.next != null) {
            ListNode right = slow.next;
            slow.next = null;
            root.right = sortedListToBST(right);
        }

        return root;
    }

    public static void main(String[] args) {
        ConvertSortedListtoBinarySearchTree instance = new ConvertSortedListtoBinarySearchTree();
        ListNode n1 = new ListNode(1);
        ListNode p = n1;
        for (int i = 2; i <= 20; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }

        TreeNode node = instance.sortedListToBST(n1);
        System.out.println(node.val);
    }
}

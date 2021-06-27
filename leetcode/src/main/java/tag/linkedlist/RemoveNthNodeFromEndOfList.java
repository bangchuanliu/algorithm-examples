package tag.linkedlist;

import common.ListHelper;
import common.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        
        ListNode helper = new ListNode(0);
        helper.next = head;

        ListNode p = head;
        ListNode q = helper;

        while (p != null && n > 0) {
            p = p.next;
            n--;
        }

        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return helper.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = ListHelper.createLinkedList(nums);
        ListNode p = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2);
        ListHelper.printLinkedList(p);
    }
}

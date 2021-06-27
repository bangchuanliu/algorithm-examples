package tag.linkedlist;

import common.ListNode;

/**
 * 148. Sort List
 * 
 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * 
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * 
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(next);

        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode l3 = new ListNode(0);
        ListNode p = l3;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return l3.next;
    }
}

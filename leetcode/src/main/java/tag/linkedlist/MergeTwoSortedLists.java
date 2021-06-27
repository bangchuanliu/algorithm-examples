package tag.linkedlist;

import common.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Input: l1 = [], l2 = []
 * Output: []
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p1 == null) return p2;
        if (p2 == null) return p1;

        ListNode helper = new ListNode(0);
        ListNode p = helper;
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
        return helper.next;
    }
}

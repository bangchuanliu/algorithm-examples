package difficulty.easy;

import common.ListNode;

/**
 * Reverse a singly linked list.
 *
 * @author bliu13 Jan 12, 2016
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        
        ListNode pre = null;
        ListNode cur = head;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

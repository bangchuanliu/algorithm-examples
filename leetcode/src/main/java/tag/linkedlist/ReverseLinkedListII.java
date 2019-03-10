package tag.linkedlist;

import common.ListNode;

/**
 * @author bliu13
 * @since Jan 17, 2016
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        int count = 1;
        while (count < m) {
            count++;
            pre = cur;
            cur = cur.next;
        }
        ListNode left = pre;
        ListNode right = cur;
        pre = null;

        while (cur != null && count <= n) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count++;
        }

        left.next = pre;
        right.next = cur;

        return helper.next;
    }
}

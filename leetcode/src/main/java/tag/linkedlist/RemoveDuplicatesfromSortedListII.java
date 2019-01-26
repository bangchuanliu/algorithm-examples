package tag.linkedlist;

import common.ListNode;

/**
 * @author bliu13
 * @since Jan 17, 2016
 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode p = dummy;

		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int dup = p.next.val;
				while (p.next != null && p.next.val == dup) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}
		}

		return dummy.next;
	}
}

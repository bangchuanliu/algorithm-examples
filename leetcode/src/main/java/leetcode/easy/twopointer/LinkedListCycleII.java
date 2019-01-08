package leetcode.easy.twopointer;

import common.ListNode;

public class LinkedListCycleII {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode p1 = head.next;
		ListNode p2 = head.next.next;

		while (p2 != null && p2.next != null && p1 != p2) {
			p1 = p1.next;
			p2 = p2.next.next;
		}

		if (p2 == null || p2.next == null) {
			return null;
		}

		p2 = head;

		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}
}

package tag.twopointer;

import common.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null || k < 0) {
			return head;
		}

		ListNode p1 = head;
		int i = 0;
		int len = 0;

		while (p1 != null) {
			len++;
			p1 = p1.next;
		}

		k = k % len;
		p1 = head;
		
		while (i < k) {
			p1 = p1.next;
			i++;
		}

		ListNode p2 = head;

		while (p1 != null && p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		if (p1 != null) {
			p1.next = head;
			ListNode newhead = p2.next;
			p2.next = null;
			return newhead;
		}

		return head;

	}
}

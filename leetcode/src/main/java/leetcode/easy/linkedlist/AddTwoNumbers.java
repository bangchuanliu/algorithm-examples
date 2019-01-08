package leetcode.easy.linkedlist;

import common.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode p1 = l1;
		ListNode p2 = l2;

		ListNode dummy = new ListNode(0);
		ListNode p3 = dummy;
		while (p1 != null && p2 != null) {
			ListNode temp = new ListNode(p1.val + p2.val);
			p3.next = temp;
			p3 = temp;
			p1 = p1.next;
			p2 = p2.next;
		}
		if (p1 != null) {
			p3.next = p1;
		} else if (p2 != null) {
			p3.next = p2;
		}

		p3 = dummy;
		int adv = 0;
		while (p3.next != null) {
			int val = p3.next.val;
			p3.next.val = (val + adv) % 10;
			adv = (val + adv) / 10;
			p3 = p3.next;
		}

		if (adv > 0) {
			ListNode temp = new ListNode(1);
			p3.next = temp;
		}
		return dummy.next;
	}
}
